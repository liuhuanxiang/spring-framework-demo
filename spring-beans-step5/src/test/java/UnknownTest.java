import cn.hutool.core.util.XmlUtil;
import com.hx.springframework.core.io.ClassPathResource;
import com.hx.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;

public class UnknownTest {
	
	public static void main(String[] args) throws IOException {
		String helloWorld = lowerFirst("Hello World");
		System.out.println(helloWorld);
		char c = 'H';
		System.out.println((int) c);
		Resource resource = new ClassPathResource("spring.xml");
		
		Document doc = XmlUtil.readXML(resource.getInputStream());
		Element documentElement = doc.getDocumentElement();
		NodeList childNodes = documentElement.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			//System.out.println(childNodes.item(i).getNodeName());
			if (null == childNodes.item(i)) {
				continue;
			}
			if (!(childNodes.item(i) instanceof Element)) {
				System.out.println(childNodes.item(i).getNodeName());
				continue;
			}
			System.out.println(childNodes.item(i).getNodeName());
			System.out.println("------------------------------------------");
			Element element = (Element) childNodes.item(i);
			for (int j = 0; j < element.getChildNodes().getLength(); j++) {
				if (!(element.getChildNodes().item(j) instanceof Element)) {
					System.out.println(childNodes.item(j).getNodeName());
					continue;
				}
				Element item = (Element) element.getChildNodes().item(j);
				System.out.println(item.getAttribute("name"));
			}
		}
		
		//System.out.println(256 >>> 8);
		//String pp = "-2147483648";
		//String ss = "10000000000000000000000000000000";
		////String ss = "01111111 11111111 11111111 11111111";
		//System.out.println(Integer.valueOf(pp));
		//System.out.println(Integer.parseInt(StringUtils.replace(ss, " ", ""), 2));
		//
		//System.out.println(Integer.toBinaryString(Integer.valueOf(pp)));
		//System.out.println(Integer.valueOf(pp) >> 2);
		//System.out.println(-10 >> 33);
		//System.out.println(Integer.toBinaryString(-10));
		//System.out.println("10000000000000000000000000000000".length());
		
		//00000000   00000000    01000000    00000000
		
	}
	
	public static String lowerFirst(CharSequence str) {
		if (null == str) {
			return null;
		} else {
			if (str.length() > 0) {
				char firstChar = str.charAt(0);
				if (Character.isUpperCase(firstChar)) {
					return Character.toLowerCase(firstChar) + subSuf(str, 1);
				}
			}
			
			return str.toString();
		}
	}
	
	public static String subSuf(CharSequence string, int fromIndex) {
		return isEmpty(string) ? null : sub(string, fromIndex, string.length());
	}
	
	public static boolean isEmpty(CharSequence str) {
		return str == null || str.length() == 0;
	}
	
	public static String sub(CharSequence str, int fromIndexInclude, int toIndexExclude) {
		if (isEmpty(str)) {
			return str(str);
		} else {
			int len = str.length();
			if (fromIndexInclude < 0) {
				fromIndexInclude += len;
				if (fromIndexInclude < 0) {
					fromIndexInclude = 0;
				}
			} else if (fromIndexInclude > len) {
				fromIndexInclude = len;
			}
			
			if (toIndexExclude < 0) {
				toIndexExclude += len;
				if (toIndexExclude < 0) {
					toIndexExclude = len;
				}
			} else if (toIndexExclude > len) {
				toIndexExclude = len;
			}
			
			if (toIndexExclude < fromIndexInclude) {
				int tmp = fromIndexInclude;
				fromIndexInclude = toIndexExclude;
				toIndexExclude = tmp;
			}
			
			return fromIndexInclude == toIndexExclude ? "" : str.toString().substring(fromIndexInclude, toIndexExclude);
		}
	}
	
	public static String str(CharSequence cs) {
		return null == cs ? null : cs.toString();
	}
	
}
