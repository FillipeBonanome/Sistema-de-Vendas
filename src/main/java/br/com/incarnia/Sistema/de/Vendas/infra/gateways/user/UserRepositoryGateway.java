package br.com.incarnia.Sistema.de.Vendas.infra.gateways.user;

import br.com.incarnia.Sistema.de.Vendas.application.gateways.UserGateway;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import br.com.incarnia.Sistema.de.Vendas.core.exceptions.UserException;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserEntity;
import br.com.incarnia.Sistema.de.Vendas.infra.persistence.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository     = userRepository;
        this.userEntityMapper   = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        Optional<UserEntity> existingEmailEntity = userRepository.findByEmail(user.getEmail());

        if (existingEmailEntity.isPresent()) {
            throw new UserException("User with email " + user.getEmail() + " already registered");
        }

        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedEntity);
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserException("User with id " + id + " not found");
        }

        UserEntity userEntity = userOptional.get();

        if(userEntity.isDeleted()) {
            throw new UserException("User with id " + id + " is deleted");
        }

        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
        return userEntityPage.map(userEntityMapper::toDomain);
    }
}
