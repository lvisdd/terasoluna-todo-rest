package com.example.todo.domain.service.account;

import com.example.todo.domain.model.Account;

public interface AccountSharedService {
    Account findOne(String username);
}
