package br.com.alura.literalura.services;

public interface IConverterDados {
    <T> T conversorDados(String json, Class<T> classe);
}
