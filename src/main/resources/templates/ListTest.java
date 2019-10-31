package templates;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


public class ListTest {


	@Test
	public void test() {
		// TemplateResolverに設定値をセット
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode("HTML5");
		resolver.setPrefix("templates/");
		resolver.setSuffix(".html");

		// TemplateEngineにTemplateResolverの値をセット
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);

		// ThymeLeafで使用するテキスト生成
		Context ctx = new Context();
		String hello = "テキストのテスト";
		ctx.setVariable("th_text", hello);

		// ThymeLaefの結果出力（templates配下のsample1.htmlを読み込む）
		String result = templateEngine.process("test", ctx);
		System.out.println(result);
		// ThymeLaefの結果出力にセットした文字列があるか
		assertThat(result, is(containsString(hello)));
	}


	@Test
	public void ThymeLeafEach(){
	//TemplateResolverに設定値をセット
	ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
	resolver.setTemplateMode("HTML5");
	resolver.setPrefix("templates/");
	resolver.setSuffix(".html");
	//TemplateEngineにTemplateResolverの値をセット
	TemplateEngine templateEngine=new TemplateEngine();
	templateEngine.setTemplateResolver(resolver);

	//ThymeLeafで使用するリスト生成
	Context ctx=new Context();
	List<String>list=Arrays.asList("aaa","bbb","ccc");
	ctx.setVariable("th_each",list);

	//ThymeLaefの結果出力（templates配下のsample1.htmlを読み込む）
	String result=templateEngine.process("test",ctx);
	System.out.println(result);
	//ThymeLaefの結果出力にセットした文字列があるか
	assertThat(result,is(containsString("aaa")));
	assertThat(result,is(containsString("ccc")));
	}

}
