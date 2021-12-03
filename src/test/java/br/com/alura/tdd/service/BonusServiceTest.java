package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

class BonusServiceTest {

    private Funcionario funcionario;
    private BonusService service;

    @BeforeEach
    public void startTest() {
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Wilson", LocalDate.now(), new BigDecimal("25000"));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularBonus(funcionario)
        );
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(funcionario);

        Assertions.assertEquals(new BigDecimal("250.00"), bonus );
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDe10000() {
        BigDecimal bonus = service.calcularBonus(funcionario);

        Assertions.assertEquals(new BigDecimal("1000 .00"), bonus );
    }

}
