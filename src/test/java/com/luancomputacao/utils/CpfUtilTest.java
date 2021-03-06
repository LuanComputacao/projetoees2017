package com.luancomputacao.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CpfUtilTest {

    private String cpfValido = "70481563172";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isCPF_CPFValido() {
        Assert.assertTrue(CpfUtil.isCPF(this.cpfValido));

    }

    @Test
    public void isCPF_CPFValido_verificadoresSubstituidos() {
        Assert.assertTrue(CpfUtil.isCPF("03346609200"));

    }

    @Test
    public void isCPF_CPFInvalido_mesmoNumero() {
        Assert.assertFalse(CpfUtil.isCPF("000000000000"));
    }

    @Test
    public void isCPF_CPFInvalido_numerosDiferentes() {
        Assert.assertFalse(CpfUtil.isCPF("11122233344"));
    }

    @Test
    public void getCPFformatado() {
        String cpfObtido = CpfUtil.getCPFformatado(this.cpfValido);
        Assert.assertTrue(cpfObtido.matches("^([0-9]{3}\\.){2}[0-9]{3}-[0-9]{2}$"));
    }
}