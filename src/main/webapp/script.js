/**
 * 
 */
var c = document.querySelector(':root');
var state = 1;

while (true) {
	var cur = c.style.getPropertyValue("--col").toString();
	switch(state) {
		case 0:
			{
			let r = parseInt(cur.substring(1, 3), 16);
			let b = parseInt(cur.substring(5), 16);
			r++;
			b--;
			let colr = r.toString(16);
			let colb = b.toString(16);
			if(r < 16) colr = "0" + colr;
			if(b < 16) colb = "0" + colb;
			var out = "#" + colr + cur.substring(3, 5) + colb;
			if(r == 255 || b == 0) state++;
			break;
			}
		case 1:
			{
			let r = parseInt(cur.substring(1, 3), 16);
			let g = parseInt(cur.substring(3, 5), 16);
			g++;
			r--;
			let colg = g.toString(16);
			let colr = r.toString(16);
			if(r < 16) colr = "0" + colr;
			if(g < 16) colg = "0" + colg;
			var out = "#" + colr + colg + cur.substring(5);
			if(g == 255 || r == 0) state++;
			break;
			}
		case 2:
				{
				let g = parseInt(cur.substring(3, 5), 16);
				let b = parseInt(cur.substring(5), 16);
				b++;
				g--;
				let colg = g.toString(16);
				let colb = b.toString(16);
				if(b < 16) colb = "0" + colb;
				if(g < 16) colg = "0" + colg;
				var out = "#" + cur.substring(1, 3) + colg + colb;
				if(b == 255 || g == 0) state = 0;
				break;
				}
	}
	c.style.setProperty("--col", out);
	
}