import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinha {
	
	public void cria() throws Exception{
		
		//leitura da imagem
		//InputStream inputStream = new FileInputStream("entrada/filme.jpg");
		InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_10.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		//cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar iamgem original pra uma nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		//configurar a fonte
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.yellow);
		graphics.setFont(fonte);
		
		//escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 100, novaAltura - 100);
		
		//escrever a nova imagem em um arquiva
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		GeradorDeFigurinha geradora = new GeradorDeFigurinha();
		geradora.cria();
		System.out.println("Stickers criado com sucesso!!!");
	}

}
