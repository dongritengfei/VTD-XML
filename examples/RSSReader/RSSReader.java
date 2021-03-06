/* 
 * Copyright (C) 2002-2006 XimpleWare, info@ximpleware.com
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

/* In this java program, we demonstrate how to use AutoPilot and VTDNav
 * class to filter elements of a particular name space. We also are going 
 * to use VTDGen's parseFile to simplify programming.
 */
package examples.RSSReader;

import com.ximpleware.*;
import java.io.*;

public class RSSReader {

	public static void main(String argv[]) {
		try {
			// open a file and read the content into a byte array
			VTDGen vg = new VTDGen();
			if (vg.parseFile("./servers.xml", true)) {
				VTDNav vn = vg.getNav();
				AutoPilot ap = new AutoPilot(vn);
				ap.selectElementNS("http://purl.org/dc/elements/1.1/", "*"); // select
																				// name
																				// space
																				// here;
																				// *
																				// matches
																				// any
																				// local
																				// name
				int count = 0;
				while (ap.iterate()) {
					System.out.print("" + vn.getCurrentIndex() + "  ");
					System.out.print("Element name ==> " + vn.toString(vn.getCurrentIndex()));
					int t = vn.getText(); // get the index of the text (char
											// data or CDATA)
					if (t != -1)
						System.out.println(" Text  ==> " + vn.toNormalizedString(t));
					System.out.println("\n ============================== ");
					count++;
				}
				System.out.println("Total # of element " + count);
			}
		} catch (NavException e) {
			System.out.println(" Exception during navigation " + e);
		}
	}
}
