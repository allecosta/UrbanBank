package com.urbanbank.service.impl;

import com.urbanbank.domain.model.User;
import com.urbanbank.domain.repository.UserRepository;
import com.urbanbank.service.UserService;
import com.urbanbank.service.exception.BusinessException;
import com.urbanbank.service.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("O usuário a ser criado não pode ser nulo."));
        ofNullable(userToCreate.getAccount()).orElseThrow(() -> new BusinessException("A conta do usuário não pode ser nula."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("O cartão do usuário não pode ser nulo"));

        this.validateChangeAbleId(userToCreate.getId(), "Criado");

        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("Este número de conta já existe");
        }

        if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("Este número de cartão já existe");
        }
        return this.userRepository.save(userToCreate);
    }

    @Transactional
    public User update(Long id, User userToUpdate) {
        this.validateChangeAbleId(id, "Atualizado");
        User dbUser = this.findById(id);

        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw  new BusinessException("Os IDs de atualização devem ser os mesmos");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeatures(userToUpdate.getFeatures());
        dbUser.setNews(userToUpdate.getNews());
        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeAbleId(id, "Excluido");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }

    private void validateChangeAbleId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("Usuário com ID %d não pode ser %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }























}
