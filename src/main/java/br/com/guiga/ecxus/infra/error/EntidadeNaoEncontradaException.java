package br.com.guiga.ecxus.infra.error;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EntidadeNaoEncontradaException extends RuntimeException {

    public EntidadeNaoEncontradaException(Class clazz, String... parametros) {
        super(EntidadeNaoEncontradaException.gerarMensagem(clazz.getSimpleName(), toMap(String.class, String.class, parametros)));
    }

    private static String gerarMensagem(String entidade, Map<String, String> parametros) {
        return StringUtils.capitalize(entidade) +
                " não encontrada para os parametros " +
                parametros;
    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType, Class<V> valueType, Object... parametros) {
        if (parametros.length % 2 == 1)
            throw new IllegalArgumentException("Parametros inválidos");
        return IntStream.range(0, parametros.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(parametros[i]), valueType.cast(parametros[i + 1])),
                        Map::putAll);
    }
}
