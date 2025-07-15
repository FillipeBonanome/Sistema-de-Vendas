package br.com.incarnia.Sistema.de.Vendas.infra.controllers.user;

import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.create.CreateUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.read.ReadUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.application.usecases.user.readall.ReadAllUserImplementation;
import br.com.incarnia.Sistema.de.Vendas.core.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserImplementation createUserImplementation;
    private final ReadUserImplementation readUserImplementation;
    private final ReadAllUserImplementation readAllUserImplementation;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserImplementation createUser, ReadUserImplementation readUserImplementation, UserDTOMapper mapper, ReadAllUserImplementation readAllUserImplementation) {
        this.createUserImplementation = createUser;
        this.readUserImplementation = readUserImplementation;
        this.userDTOMapper = mapper;
        this.readAllUserImplementation = readAllUserImplementation;
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

    @GetMapping
    public ResponseEntity<Page<CreateUserResponse>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        Page<User> userPage = readAllUserImplementation.findAll(pageable);
        Page<CreateUserResponse> userResponsePage = userPage.map(userDTOMapper::toResponse);
        return ResponseEntity.ok(userResponsePage);
    }

}
