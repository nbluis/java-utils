package com.javautils;

public class StringUtils {

	private static final char CHARACTER_SPACE = ' ';

	public StringUtils() {}

	/**
	 * Preenche (ou trunca) {@link String} a esquerda.
	 * 
	 * @param value a ser considerado.
	 * @param length novo tamanho esperado.
	 * @return {@link String} com o novo tamanho esperado. 
	 * 		Caso a {@link String} parâmetro seja maior que o tamanho esperado ela sera quebrada 
	 * 			removendo ítens a esquerda, do contrário retornará uma nova {@link String} com espeços
	 * 			a esquerda.
	 */
	public static final String lPad(String value, int length) {
		return lPad(value, length, CHARACTER_SPACE);
	}

	/**
	 * Preenche (ou trunca) {@link String} a esquerda.
	 * 
	 * @param value a ser considerado.
	 * @param length novo tamanho esperado.
	 * @param pad caracter a ser utilizado para preencher a esquerda da {@link String}
	 * @return {@link String} com o novo tamanho esperado. 
	 * 		Caso a {@link String} parâmetro seja maior que o tamanho esperado ela sera quebrada 
	 * 			removendo ítens a esquerda, do contrário retornará uma nova {@link String} preenchida 
	 * 			com o caracter do parâmetro a esquerda.
	 */
	public static final String lPad(String value, int length, char pad) {
		if (length <= 0) throw new IllegalArgumentException("invalid argument");
		char[] newValue = new char[length];
		char[] tmp = (value != null) ? value.toCharArray() : new char[0];
		int padSize = length - tmp.length;
		for (int i = 0; i < length; i++)
			newValue[i] = (i < padSize) ? pad : tmp[i - padSize];
		return new String(newValue);
	}

	/**
	 * Preenche (ou trunca) {@link String} a direita.
	 * 
	 * @param value a ser considerado.
	 * @param length novo tamanho esperado.
	 * @return {@link String} com o novo tamanho esperado. 
	 * 		Caso a {@link String} parâmetro seja maior que o tamanho esperado ela sera quebrada 
	 * 			removendo ítens a direita, do contrário retornará uma nova {@link String} com espeços
	 * 			a direita.
	 */
	public static final String rPad(String value, int length) {
		return rPad(value, length, CHARACTER_SPACE);
	}

	/**
	 * Preenche (ou trunca) {@link String} a direita.
	 * 
	 * @param value a ser considerado.
	 * @param length novo tamanho esperado.
	 * @param pad caracter a ser utilizado para preencher a esquerda da {@link String}
	 * @return {@link String} com o novo tamanho esperado. 
	 * 		Caso a {@link String} parâmetro seja maior que o tamanho esperado ela sera quebrada 
	 * 			removendo ítens a direita, do contrário retornará uma nova {@link String} preenchida 
	 * 			com o caracter do parâmetro a direita.
	 */
	public static final String rPad(String value, int length, char pad) {
		if (length <= 0) throw new IllegalArgumentException("invalid argument");
		char[] newValue = new char[length];
		char[] tmp = (value != null) ? value.toCharArray() : new char[0];
		for (int i = 0; i < length; i++)
			newValue[i] = (i < tmp.length) ? tmp[i] : pad;
		return new String(newValue);
	}

}
