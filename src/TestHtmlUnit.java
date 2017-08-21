import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestHtmlUnit {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(false);
		
		HtmlPage page = webClient.getPage("https://www.capitalone.com/credit-cards/compare/");
		webClient.waitForBackgroundJavaScript(20000);
		
		List<HtmlAnchor> acs = page.getAnchors();
		for(HtmlAnchor anch : acs){
			System.out.println(anch.asText() + "---" + anch.getAttribute("href"));
//			System.out.println(anch.getAttribute("ng-href"));
		}
		
		webClient.close();
	}

}
