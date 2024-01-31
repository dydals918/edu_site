package com.hkit.lifetime.account;

import com.hkit.lifetime.company.CompanyService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final CompanyService companyService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("register")
    public String inRegister() {
        return "register";
    }

    @PostMapping("/api/account/register")
    public String accountRegister(AccountDto accountDto) {
        Optional<Account> account = accountService.duplicateCheck(accountDto.id());
        if (account.isEmpty()) {
            AccountDto encodeAccount = encodePw(accountDto);
            accountService.save(encodeAccount);
            return "home";
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id in Use");
        }

    }

    @PostMapping("/api/account/check")
    public HttpStatus idCheck(@RequestParam(name = "id") String id){
        Optional<Account> account = accountService.duplicateCheck(id);
        if (account.isEmpty()){
            return HttpStatus.OK;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id in Use");
        }
    }

    @PostMapping("/api/account/delete")
    public String accountDelete(@RequestParam(name = "sessionId") String id) {
        accountService.delete(id);
        return "home";
    }

    @PostMapping("/api/account/update")
    public String accountUpdate(AccountDto accountDto) {
        accountService.update(accountDto);
        return "home";
    }

    /*
        input pw encode
     */
    private AccountDto encodePw(AccountDto accountDto) {
        return new AccountDto(
                null,
                accountDto.id(),
                bCryptPasswordEncoder.encode(accountDto.pw()),
                accountDto.name(),
                accountDto.birth(),
                accountDto.email(),
                accountDto.tel(),
                accountDto.gender(),
                accountDto.address1(),
                accountDto.address2()
        );
    }

}
