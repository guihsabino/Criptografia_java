package Aula_POO_Cripto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CriptografiaDescriptografia {
	public static void main(String args[]) {
		// Criando a Senha que será utilizada
		String senha = "AulaPOO";
		// Exibindo a Senha Criada
		System.out.println("Senha Original: " + senha);
		// Gera a criptografia da Chave
		Cipher Gerador = null;
		try {
			// Gerador de Chave usando os Algoritmos de Criptografia
			KeyGenerator GerarChave = KeyGenerator.getInstance("AES");

			// Torna o segredo da chave secreto
			SecretKey ChaveSecreta = GerarChave.generateKey();

			try {
				// Convertendo para Algoritmo AES
				Gerador = Cipher.getInstance("AES");
			} catch (NoSuchPaddingException e1) {

				e1.printStackTrace();
			}

			try {
				// Aplicando na Chave Secreta
				Gerador.init(Cipher.ENCRYPT_MODE, ChaveSecreta);
			} catch (InvalidKeyException e) {
				e.printStackTrace();

				try {
					Gerador.init(Cipher.DECRYPT_MODE, ChaveSecreta);
					
				} catch (InvalidKeyException e1) {
					e1.printStackTrace();
				}
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		try {
			// Realizando o processo de todos os citados acima
			byte[] SenhaCriptografada = Gerador.doFinal(senha.getBytes());

			// Apresentação da Senha Criptografada
			System.out.println("Senha Criptografada: " + SenhaCriptografada);
			
			// Realizando o processo de todos os citados acima descriptografando
			byte[] SenhaDescriptografada = Gerador.doFinal(SenhaCriptografada);

			// Apresentação da Senha Descriptografada
			System.out.println("Senha Descriptografada: " + new String(SenhaDescriptografada));

		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
	}

}
