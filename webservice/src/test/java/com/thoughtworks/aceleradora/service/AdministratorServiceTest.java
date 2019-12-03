package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Administrator;
import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.AdministratorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorServiceTest {

    @Mock
    private AdministratorRepository administratorRepository;

    @InjectMocks
    private AdministratorService administratorService;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    private Administrator expectedAdministrator;

    @Before
    public  void setup(){
        expectedAdministrator = new Administrator("username", "password");
    }

    @Test
    public void shouldReturnOKIfAddValidStage() {

        when(administratorRepository.save(expectedAdministrator)).thenReturn(expectedAdministrator);

        Administrator administrator = administratorService.save(expectedAdministrator);

        Assert.assertEquals(expectedAdministrator.getUsername(),administrator.getUsername());

        Assert.assertEquals(expectedAdministrator.getPassword(), administrator.getPassword());

        Mockito.verify(administratorRepository, Mockito.times(1)).save(expectedAdministrator);
    }
}
