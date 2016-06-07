function tekenPlattegrond(){
	ctx.rect(25, 675, 50, 50);//kassa links
	ctx.rect(110, 675, 50, 50);
	ctx.rect(160, 675, 50, 50);
	ctx.rect(245, 675, 50, 50);
	ctx.rect(295, 675, 50, 50);
	ctx.rect(380, 675, 50, 50);
	ctx.rect(430, 675, 50, 50);
	ctx.rect(525, 675, 100, 50);//kassa rechts

	//muren bij ingang
	ctx.rect(650, 724, 125, 5);
	ctx.rect(650, 724, 125, 5);
	ctx.rect(850, 724, 125, 5);
	ctx.rect(850, 724, 125, 5);

//			  x  y   w  h
	ctx.rect(0,0,25,400);//37
	ctx.rect(100,100,25,200);//30
	ctx.rect(125,100,25,200);//28
	ctx.rect(200,100,25,200);//26
	ctx.rect(225,100,25,200);//24
	ctx.rect(300,100,25,200);//22
	ctx.rect(325,100,25,200);//20
	ctx.rect(400,100,25,200);//18
	ctx.rect(425,100,25,200);//16
	ctx.rect(500,100,25,200);//14
	ctx.rect(525,100,25,200);//12
	ctx.rect(600,100,25,200);//10
	ctx.rect(625,100,25,200);//8

	ctx.rect(975,25,25,375);//32
	ctx.rect(975,400,25, 325);//31

	ctx.rect(25,0,275,25);//35
	ctx.rect(300,0,300,25);//34
	ctx.rect(600,0,400,25);//33
	ctx.rect(0, 400, 25, 275);//36

	ctx.rect(75,425,35,150);//29
	ctx.rect(110,425,35,150);//27
	ctx.rect(200,400,25,200);//25
	ctx.rect(225,400,25,200);//23
	ctx.rect(300,400,25,200);//21
	ctx.rect(325,400,25,200);//19
	ctx.rect(400,400,25,200);//17
	ctx.rect(425,400,25,200);//15
	ctx.rect(500,400,25,200);//13
	ctx.rect(525,400,25,200);//11
	ctx.rect(600,400,25,275);//9
	ctx.rect(625,400,25,325);//7

	ctx.rect(700, 475, 75, 100);//2
	ctx.rect(825, 475, 75, 100);//1

	ctx.rect(700, 300, 75, 100);//3
	ctx.rect(825, 300, 75, 100);//4

	ctx.rect(700, 125, 75, 100);//5
	ctx.rect(825, 125, 75, 100);//6

	ctx.stroke();
}
function schrijfSchapNamen(lijst){
	ctx.font = "12px Arial";
	ctx.textAlign = "center";
	ctx.save();
	ctx.rotate(-Math.PI/2);
	ctx.fillText(lijst.s36,-200,15);
	ctx.fillText(lijst.s37, -500, 15);
	ctx.fillText(lijst.s28, -200, 140);
	ctx.fillText(lijst.s24, -200, 240);
	ctx.fillText(lijst.s20, -200, 340);
	ctx.fillText(lijst.s16, -200, 440);
	ctx.fillText(lijst.s12, -200, 540);
	ctx.fillText(lijst.s27, -500, 130);
	ctx.fillText(lijst.s23, -500, 240);
	ctx.fillText(lijst.s19, -500, 340);
	ctx.fillText(lijst.s15, -500, 440);
	ctx.fillText(lijst.s11, -500, 540);
	ctx.fillText(lijst.s8, -200, 640);
	ctx.fillText(lijst.s7, -500, 640);
	ctx.restore();	
	ctx.save();
	ctx.rotate(Math.PI/2);	
	ctx.fillText(lijst.s30,200,-110);
	ctx.fillText(lijst.s26,200,-210);
	ctx.fillText(lijst.s22,200,-310);
	ctx.fillText(lijst.s18,200,-410);
	ctx.fillText(lijst.s14,200,-510);
	ctx.fillText(lijst.s32,200,-985);
	ctx.fillText(lijst.s29,500,-90);
	ctx.fillText(lijst.s25,500,-210);
	ctx.fillText(lijst.s21,500,-310);
	ctx.fillText(lijst.s17,500,-410);
	ctx.fillText(lijst.s13,500,-510);
	ctx.fillText(lijst.s31,500,-985);
	ctx.fillText(lijst.s10,200,-610);
	ctx.fillText(lijst.s9,500,-610);
	ctx.restore();
	ctx.fillText(lijst.s34, 400, 15);
	ctx.fillText(lijst.s35, 150, 15);
	ctx.fillText(lijst.s33, 750, 15);
	ctx.fillText(lijst.s2, 725, 525);
	ctx.fillText(lijst.s1, 850, 525);
	ctx.fillText(lijst.s3, 725, 355);
	ctx.fillText(lijst.s4, 850, 355);
	ctx.fillText(lijst.s5,725, 185);
	ctx.fillText(lijst.s6, 850, 185);
	ctx.fillText("ingang", 800, 700);
	ctx.fillText("kassa's", 300, 700);
}
function schrijfSchapNummers(){
	var lijst = {};
	var x = 1;
	while(x < 40){
		lijst["s"+x] = "schap " + x;
		x++;
	}
	schrijfSchapNamen(lijst);
}
function getKruispunten(){
	var hoeken = [];
	//	  x    y
	hoeken.push({x:570, y:640});
	hoeken.push({x:570, y:350});
	hoeken.push({x:570, y:65});
	hoeken.push({x:475, y:65});
	hoeken.push({x:375, y:65});
	hoeken.push({x:275, y:65});
	hoeken.push({x:175, y:65});
	hoeken.push({x:50, y:65});
	
	hoeken.push({x:675, y:640});
	hoeken.push({x:800, y:640});
	hoeken.push({x:935, y:640});
	hoeken.push({x:675, y:440});
	hoeken.push({x:800, y:440});
	hoeken.push({x:935, y:440});
	hoeken.push({x:675, y:260});
	hoeken.push({x:800, y:260});
	hoeken.push({x:935, y:260});
	hoeken.push({x:675, y:65});
	hoeken.push({x:800, y:65});
	hoeken.push({x:935, y:65});
	
	hoeken.push({x:675, y:350});
	hoeken.push({x:475, y:350});
	hoeken.push({x:375, y:350});
	hoeken.push({x:275, y:350});
	hoeken.push({x:175, y:350});
	hoeken.push({x:50, y:350});
	
	hoeken.push({x:50, y:640});
	hoeken.push({x:175, y:640});
	hoeken.push({x:275, y:640});
	hoeken.push({x:375, y:640});
	hoeken.push({x:475, y:640});
	return hoeken;
}
function tekenLijnNaar(positie){
	console.log("teken lijn naar " + positie.x  +", " + positie.y);
	//positie = {x: xcoord, y: ycoord}
}
function update(){
	var tx = targetX - x,
	    ty = targetY - y,
	    dist = Math.sqrt(tx*tx+ty*ty),
	    rad = Math.atan2(ty,tx),
	    angle = rad/Math.PI * 180;
	
	    velX = (tx/dist)*speed,
	    velY = (ty/dist)*speed;
	    //console.log(Math.round(y) + " x: " + Math.round(x));
	
	    x += velX;
	    y += velY;
	   
	
	  //  ctx.clearRect(0,0,500,500);
		ctx.beginPath();
	    ctx.arc(x,y,5,0,Math.PI*2);
	    ctx.fill();
		if(y - targetY < 1 && x - targetX < 1){
			try{
				targetY = 600;//targetLijst[targetLijst.length - index][1];
				targetX = 600;//targetLijst[targetLijst.length - index][0];
				index += 1;
			} catch(error){
				console.log(error);
				//getPuntNaastPunt(getPuntOnderPunt(getClosedHoekpunt()), "rechts");
				
			}
		}
		
	setTimeout(update,10);
}