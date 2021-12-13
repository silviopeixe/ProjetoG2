package com.bcopstein;

import com.bcopstein.Funcionario;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bcopstein.Email;
import com.bcopstein.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionariosTest {
  private Funcionario funcionario;
  private Map<String,Funcionario> funcionariosPorSexo;
 // private Map<String,Funcionario> esperado;
  String Sexo = "masculino";
  

      @Test
      void funcionarioGetEMail(){
       Funcionario  mockfuncionario = mock(Funcionario.class); 
       funcionario = new Funcionario(5,"Silvio","Costa","teste@teste.com.br","masculino");
       when(mockfuncionario.geteMail()).thenReturn("teste@teste.com.br");
       assertEquals(mockfuncionario.geteMail(),funcionario.geteMail());
      }
     /*
      @Test
      void emailDosFuncionariosDoSexo(String sexo){
        funcionariosPorSexo = new HashMap<>();
        if(funcionario.getGender() == sexo){
          funcionariosPorSexo.put(funcionario.geteMail(),funcionario);
        }
        
       
        */

      }
      
    /*  
     // setup mocks
        Bairro mockBairro = mock(Bairro.class);
        when(mockBairro.getArea()).thenReturn(a2);
        when(mockBairro.getNome()).thenReturn("Auxiliadora");
        when(mockBairro.getCustoTransporte()).thenReturn(10.0);

    
    */

/* 
final List<Apple> greenApples = apples.stream().filter(a -> a.color.equals("green")).collect(Collectors.toList());
        assertEquals(greenApples.size(), 2);

*/