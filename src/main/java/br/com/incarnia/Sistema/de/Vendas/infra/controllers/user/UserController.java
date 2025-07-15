package br.com.incarnia.Sistema.de.Vendas.infra.controllers.user;

import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.create.CreateUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.read.ReadUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserImplementation createUserImplementation;
    private final ReadUserImplementation readUserImplementation;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserImplementation createUser, ReadUserImplementation readUserImplementation, UserDTOMapper mapper) {
        this.createUserImplementation = createUser;
        this.readUserImplementation = readUserImplementation;
        this.userDTOMapper = mapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        User userObject = userDTOMapper.toUser(request);
        User user = createUserImplementation.createUser(userObject);        //validation
        return ResponseEntity.ok(userDTOMapper.toResponse(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<CreateUserResponse> getUserById(@PathVariable(name = "id") Long id) {
        User user = readUserImplementation.findById(id);
        return ResponseEntity.ok(userDTOMapper.toResponse(user));
    }

}
