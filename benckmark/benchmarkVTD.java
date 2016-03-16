package benckmark;
import com.ximpleware.*;
import com.ximpleware.VTDGen.GBKReader;
import com.ximpleware.parser.*;

import java.io.*;

public class benchmarkVTD {
	public static void main(String[] args) throws NavException {

		long l, lt = 0;
		try {
			InputStream fis = benchmarkVTD.class.getResourceAsStream("book-order.xml");
			int fl = fis.available();
			byte[] ba = new byte[fl];
			// FileInputStream fis1 = new FileInputStream(f1);
			// byte[] ba1 = new byte[(int)f1.length()];
			fis.read(ba);
			// fis1.read(ba1);
			VTDGen vg = new VTDGen();
			// vg.setDoc(ba);
			System.out.println("fl is " + fl);
			System.out.println(" 10>>11 " + (10 >> 11));
			int total;
			if (fl < 1000)
				total = 40000;
			else if (fl < 3000)
				total = 20000;
			else if (fl < 6000)
				total = 4000;
			else if (fl < 15000)
				total = 1600;
			else if (fl < 30000)
				total = 1000;
			else if (fl < 60000)
				total = 600;
			else if (fl < 120000)
				total = 300;
			else if (fl < 500000)
				total = 100;
			else if (fl < 2000000)
				total = 40;
			else
				total = 5;
			System.out.println("total is " + total);

			vg.setDoc(ba);
			vg.parse(true);

			// VTDNav nav = vg.getNav();
			// boolean element = nav.toElement(VTDNav.FC, "Customer");
			// element = nav.toElement(VTDNav.FIRST_CHILD);
			// int textIndex = nav.getText();
			// System.out.println(nav.toString(textIndex));//输出经转义后的文本，比如："&amp;"转成"&"，把"&lt;"转成"""等，详见VTDNav.getCharResolved()方法
			// System.out.println(nav.toRawString(textIndex));//输出原始文本，即不进行转义
			// element = nav.toElement(VTDNav.NEXT_SIBLING);
			// System.out.println(nav.toString(nav.getCurrentIndex()));//输出tag名称
			// textIndex = nav.getText();
			// System.out.println(nav.toString(textIndex));
			//
			// return ;

			l = System.currentTimeMillis();
			while (System.currentTimeMillis() - l < 30000) {
				vg.setDoc(ba);
				vg.parse(true);
			}
			for (int j = 0; j < 10; j++) {
				l = System.currentTimeMillis();
				for (int i = 0; i < total; i++) {
					vg.setDoc(ba);
					vg.parse(true);
				}
				long l2 = System.currentTimeMillis();
				lt = lt + (l2 - l);
			}
			// System.out.println("latency "+ ((double)lt/10)+ " ms");
			System.out.println(" average parsing time ==> " + ((double) (lt) / total / 10) + " ms");
			System.out.println(" performance ==> " + (((double) fl * 1000 * total) / ((lt / 10) * (1 << 20))));
		} catch (ParseException e) {
			System.out.println(" Not wellformed -->" + e);
		} catch (IOException e) {
			System.out.println(" io exception ");
		}
	}
}