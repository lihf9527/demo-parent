package com.example.repository.account;

import com.example.entity.account.Account;
import com.example.entity.account.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        Account account = new Account(new BigDecimal(100));
        Account account1 = new Account(new BigDecimal(200));
        accountRepository.insert(account);
        accountRepository.insert(account1);

        Person person = new Person("Jerry");
        person.setAccounts(Arrays.asList(account, account1));
        personRepository.insert(person);
    }

    @Test
    public void test2() {
        List<Person> list = personRepository.findAll();
        list.forEach(System.out::println);
        System.out.println(list.get(0).getAccounts().get(0));
    }

    @Test
    public void test3() {
        accountRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);
    }
}
