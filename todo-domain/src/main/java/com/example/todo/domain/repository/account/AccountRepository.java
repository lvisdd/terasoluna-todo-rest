package com.example.todo.domain.repository.account;

import com.example.todo.domain.model.Account;

public interface AccountRepository {
    Account findOne(String username);
}
