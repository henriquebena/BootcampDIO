package br.com.curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DesafiosDio {

	// usados no desafio 4
	public static int resultado = 0;
	public static int contador = 0;
	public static int soma = 0;

	public static void main(String[] args) {

		// m.imprimirMultiplos(3,18);

//
//		desafio1("teste");

//		desafio2("[asdosahidbasidnasiduisand]");

//		desafio3(12);

//		desafio4();

//		desafio5(10);


	}

	//Desafio: Checagem de Palíndromo
	public static boolean desafio1(String s) {

		int tamanho = s.length();
		String novo = "";

		for (int i = 1; i <= tamanho; i++) {
			novo += s.charAt(tamanho - i);
		}

		return novo.equals(s.toUpperCase());

	}

//	Desafio: Validação de Parênteses
	public static boolean desafio2(String s) {

		String tipo = s.substring(0, 1);

		switch (tipo) {
		case "[": {
			return s.endsWith("]");
		}
		case "(": {
			return s.endsWith(")");
		}
		case "{": {
			return s.endsWith("}");
		}
		default:
			return false;
		}

	}

//	Desafio: Quadrados Perfeitos
	public static void desafio3(int num) {

		List<Integer> raizes = comporQuadrado(num);

		raizes = raizes.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		percorrer(raizes, num);

		System.out.println(resultado);

	}

	// Desafio: Classificando Matrizes
	public static void desafio4() {

		int i;
		int nums[] = new int[5];
		nums[0] = 4;
		nums[1] = 3;
		nums[2] = 1;
		nums[3] = 2;
		nums[4] = 4;

		int j = 0;

		// [4, 3, 1, 2, 4]
		for (i = 0; i < nums.length; i++) {
			if ((nums[i] % 2) == 0) {

				int par = nums[i];
				int impar = nums[j];

				nums[i] = impar;
				nums[j] = par;

				j++;

			}
		}

		for (var entry : nums) {
			System.out.println(entry);
		}

	}

	// Desafio: Classificando Matrizes
	public static void percorrer(List<Integer> l, int num) {
		l.forEach(n -> {
			if (soma == num) {
				return;
			}

			boolean lop = true;

			do {
				lop = !somar(n, num);
			} while (lop);

		});

		if (soma == num) {
			if (resultado == 0) {
				resultado = contador;
			} else {
				if (contador < resultado) {
					resultado = contador;
				}
			}
		}
		if (l.size() > 1) {
			l.remove(0);
			soma = 0;
			contador = 0;
			percorrer(l, num);
		}
	}

	// Desafio: Classificando Matrizes
	public static boolean somar(int n, int meta) {
		if ((soma + n) <= meta) {
			soma += n;
			contador++;

			if (soma == meta) {
				return true;
			}
		} else {
			return true;
		}
		return false;
	}

	// Desafio: Classificando Matrizes
	public static List<Integer> comporQuadrado(int numero) {
		List<Integer> ret = new ArrayList<Integer>();

		boolean para = true;

		for (int i = 1; para; i++) {
			if (i * i > numero) {
				para = false;
			} else {
				ret.add(i * i);
			}
		}
		return ret;

	}

//	Desafio: Fatorial Desajeitad
	public static void desafio5(int num) {
		System.out.println(calcularDesafio5(num, false));
	}

	
//	Desafio: Fatorial Desajeitado
	public static int calcularDesafio5(int num, boolean negativo) {

		int res = 0;
		int cnt = 1;
		int tmp = num;
		num--;

		while (num > 0) {
			// TODO: Calcule o valor do fatorial de "n", atrinbuindo o retorno a "r".

			switch (cnt) {
			case 1: {
				if (negativo) {
					tmp = (-tmp);
				}

				if (res == 0) {
					res = tmp * num;
				} else {
					res = res * num;
				}
				cnt = 2;
				break;
			}
			case 2: {
				res = res / num;
				cnt = 3;
				break;
			}
			case 3: {
				res = res + num;
				cnt = 4;
				break;
			}
			case 4: {
				if ((num - 1) > 0) {

					int sub = calcularDesafio5(num, true);

					if (sub < 0) {
						res = res + sub;
					} else {
						res = res - sub;
					}

					cnt = 9;
				} else {
					res = res - num;
				}

				break;
			}
			}

			num--;

		}

		return res;

	}
	

	public void imprimirMultiplos(int num, int limite) {

		int soma = 0;

		for (int i = 1; i <= limite; i++) {

			if ((i % num) == 0) {
				soma += i;
			}
		}

		System.out.println(soma);

	}

}
