const ev = 
	'-----BEGIN CERTIFICATE-----\n'+
	'MIII1DCCB7ygAwIBAgIMJYsZD+/R9o7UxsFRMA0GCSqGSIb3DQEBCwUAMGIxCzAJ\n'+
	'BgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMTgwNgYDVQQDEy9H\n'+
	'bG9iYWxTaWduIEV4dGVuZGVkIFZhbGlkYXRpb24gQ0EgLSBTSEEyNTYgLSBHMzAe\n'+
	'Fw0xODAzMDIxMTQxMDJaFw0yMDAzMDIxMTQxMDJaMIIBCzEdMBsGA1UEDwwUUHJp\n'+
	'dmF0ZSBPcmdhbml6YXRpb24xDzANBgNVBAUTBjU3ODYxMTETMBEGCysGAQQBgjc8\n'+
	'AgEDEwJVUzEeMBwGCysGAQQBgjc8AgECEw1OZXcgSGFtcHNoaXJlMQswCQYDVQQG\n'+
	'EwJVUzEWMBQGA1UECBMNTmV3IEhhbXBzaGlyZTETMBEGA1UEBxMKUG9ydHNtb3V0\n'+
	'aDEgMB4GA1UECRMXVHdvIEludGVybmF0aW9uYWwgRHJpdmUxHTAbBgNVBAoTFEdN\n'+
	'TyBHbG9iYWxTaWduLCBJbmMuMSkwJwYDVQQDEyBpbnRyYW5ldC5pbnRlcm5hbC5n\n'+
	'bG9iYWxzaWduLmNvbTCCAiIwDQYJKoZIhvcNAQEBBQADggIPADCCAgoCggIBAKnX\n'+
	'5OkTJ7c8gYgbVIdcy8B4HRKTTkxQa+tdrDSHcFtWgMfT4Sv1r3SEtCDGdBzU+Joi\n'+
	'd0zXACvD8t2QxJqLUOewOVATwyLpItLPHlwQDfBU2bLPQNlZc7Np1Q3zBiKP/U1i\n'+
	'YSGSXUbknMfBcouZ0+oATimtXJpMyUQ8B1MhpAtDIb9Qn9Kq1rneHYbJrM9zgVX+\n'+
	'FBg341laiTzW+FU+2OkjV7gQKeAb47KvhlTtqEjhAx9t8lrbzE9tS3UhhEf4YRJi\n'+
	'3Go1a8BwWDcFFIh1X+wVM2G01i+iVgq74QXMMdUU16IDTI4ODdck1u5k+ZrfVqzT\n'+
	'jOkWLo0j2R60Y/oedBzwJhTWdXdEWJQ/smB9e1C/oPj2O2m0QuUorYe+Fu+vTfrI\n'+
	'63UwGSly+sza+rDpU5tKsdCrK+dJm7X/ogZcqKR7jt4oyFNKSpjaEGYuvgGlOvD3\n'+
	'T14p6kQ1Exxn/S36Mv3QulMrB95vIHuSpjrWFPZnwKcwDJ6/uR0QbRWIKBQPAGH5\n'+
	'/bCZXyXGRc6RbOJ9ApHvtCZpOjZTELJAw5vBkCx32wXkGnxeN9rlxNBUkBF/OrpJ\n'+
	'8ePFwYFOgZScWGVAJXS+dNVoikt5+ANElV+VjghDYqht+HSslbodoXHpxhKpSwvG\n'+
	'kYYs2DrxjNxQjMuTQ1QFJGF1eYZKVw0ep6CX7bz/AgMBAAGjggPdMIID2TAOBgNV\n'+
	'HQ8BAf8EBAMCBaAwgZYGCCsGAQUFBwEBBIGJMIGGMEcGCCsGAQUFBzAChjtodHRw\n'+
	'Oi8vc2VjdXJlLmdsb2JhbHNpZ24uY29tL2NhY2VydC9nc2V4dGVuZHZhbHNoYTJn\n'+
	'M3IzLmNydDA7BggrBgEFBQcwAYYvaHR0cDovL29jc3AyLmdsb2JhbHNpZ24uY29t\n'+
	'L2dzZXh0ZW5kdmFsc2hhMmczcjMwVQYDVR0gBE4wTDBBBgkrBgEEAaAyAQEwNDAy\n'+
	'BggrBgEFBQcCARYmaHR0cHM6Ly93d3cuZ2xvYmFsc2lnbi5jb20vcmVwb3NpdG9y\n'+
	'eS8wBwYFZ4EMAQEwCQYDVR0TBAIwADBFBgNVHR8EPjA8MDqgOKA2hjRodHRwOi8v\n'+
	'Y3JsLmdsb2JhbHNpZ24uY29tL2dzL2dzZXh0ZW5kdmFsc2hhMmczcjMuY3JsMCsG\n'+
	'A1UdEQQkMCKCIGludHJhbmV0LmludGVybmFsLmdsb2JhbHNpZ24uY29tMB0GA1Ud\n'+
	'JQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAdBgNVHQ4EFgQUC2dX0+PLe2pEL7oY\n'+
	'1Ajhp3c7aM0wHwYDVR0jBBgwFoAU3bPnbagu6MVObs905nU8lBXO6B0wggH3Bgor\n'+
	'BgEEAdZ5AgQCBIIB5wSCAeMB4QB3AKS5CZC0GFgUh7sTosxncAo8NZgE+RvfuON3\n'+
	'zQ7IDdwQAAABYeaD+ewAAAQDAEgwRgIhAJ5HVPgn4rc0pJXzYF3oNWxe9tNCBDvG\n'+
	'/X0wN0IISCwbAiEAj8FpBjMHsG/wrWFtL2nrw94uG+7725r5d41yUaE69tEAdgBW\n'+
	'FAaaL9fC7NP14b1Esj7HRna5vJkRXMDvlJhV1onQ3QAAAWHmg/qZAAAEAwBHMEUC\n'+
	'IQCUIueuyp+/bZX2L3ZIuySPchXJGPULfDNrWzCKo5t5AAIgN2uszpfH+tNZkC+k\n'+
	'jG7Zvrfwv8yl1LzJtYLq4Mx8RoQAdgDd6x0reg1PpiCLga2BaHB+Lo6dAdVciI09\n'+
	'EcTNtuy+zAAAAWHmg/uWAAAEAwBHMEUCIQChg90LYYx1a8KycNC/jaPozR7orWXl\n'+
	'vUtlMHWIxsOuSQIgRhP5hSsjcnZF5b4CcVBcoG7o3Cl9WLwfKKIpyEDd1aMAdgDu\n'+
	'S723dc5guuFCaR+r4Z5mow9+X7By2IMAxHuJeqj9ywAAAWHmg/zuAAAEAwBHMEUC\n'+
	'IQCYDR1RhjsOsq/AZS3UqreGggxxL8KMKD3bTtYJhKPx0AIgKnYk3bHJvoXgP/mD\n'+
	'JXPozK1Fs4+YeAEC9k8JTrloUAAwDQYJKoZIhvcNAQELBQADggEBAKstSJGi+S1x\n'+
	'4e0XIEpICryImFJSVcRa44AhkgpSSn1+OyFrK3xZgb90YvTIVbEJh6E0EmJs3jeR\n'+
	'9Ok2yDbM9t1+m8WjbFQPxT8BPmrOljGD9WOg16UAMonnk0frNqkvNj9BYDTQYqtd\n'+
	'PAKi+Di6Z+birF11xZUXpQZqoUT9EAUEekRKwgZ2jfhSqF/sJiJFzlUOJrbi+DMp\n'+
	'QifYY6j95pdO53UOcYUH4W39bFPdTiG0EmLW8AHsAN0zzgKcxAQXZttU7SZqpzIZ\n'+
	'UTaRNGLkZiLNKGQtO80m9Tc1NIjo/vR/+wHI6Yji+anJUXQnZk2Kh/U3VypGPPlT\n'+
	'+nnE1bqlMzY=\n'+
	'-----END CERTIFICATE-----\n';

const ov = 
	'-----BEGIN CERTIFICATE-----\n'+
	'MIIGYTCCBUmgAwIBAgIMZXy7FqrvOHiyJ8oqMA0GCSqGSIb3DQEBCwUAMGYxCzAJ\n'+
	'BgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMTwwOgYDVQQDEzNH\n'+
	'bG9iYWxTaWduIE9yZ2FuaXphdGlvbiBWYWxpZGF0aW9uIENBIC0gU0hBMjU2IC0g\n'+
	'RzIwHhcNMTgwNzI2MDUzNDQzWhcNMTkwNzI3MDUzNDQzWjB5MQswCQYDVQQGEwJK\n'+
	'UDEOMAwGA1UECAwFT3Nha2ExEDAOBgNVBAcMB0liYXJha2kxFTATBgNVBAsMDERp\n'+
	'cmVjdCBTYWxlczEVMBMGA1UECgwMU1VOU1RBUiBpbmMuMRowGAYDVQQDDBEqLnN1\n'+
	'bnN0YXItc2hvcC5qcDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAK9K\n'+
	'QOcHQ18KKrYnTEYTKv1+PvHszLSopF8xmm4C1FPO0BIyLBGEut1KwjLlIWLAVsap\n'+
	'AREpvji7JOWDlUnIyidNbX5cmUtAC6YHqftcZ2c6BbBliPSpMBYDn+/ilPliPTAi\n'+
	'HobvRV7k5LFrvZQz0GRMlqtzx1hJwk+j0nglvCKaWrxqof33tTmu2uTa3md7QiyN\n'+
	'MCRMTmDlxoSxNXdz1Wc5FJ2+hK5qOckLgSPeYD/ORpf1bLImHzuEm1sKKtAiVuj9\n'+
	'v6uyQ3TAuIwPNb1E11+mB6T1G8jJolF69pUuufRvfPyaVi3beWTILmc2LwEpbpy8\n'+
	'tBBNUs6F+BlaMo6h5YMCAwEAAaOCAvowggL2MA4GA1UdDwEB/wQEAwIFoDCBoAYI\n'+
	'KwYBBQUHAQEEgZMwgZAwTQYIKwYBBQUHMAKGQWh0dHA6Ly9zZWN1cmUuZ2xvYmFs\n'+
	'c2lnbi5jb20vY2FjZXJ0L2dzb3JnYW5pemF0aW9udmFsc2hhMmcycjEuY3J0MD8G\n'+
	'CCsGAQUFBzABhjNodHRwOi8vb2NzcDIuZ2xvYmFsc2lnbi5jb20vZ3Nvcmdhbml6\n'+
	'YXRpb252YWxzaGEyZzIwVgYDVR0gBE8wTTBBBgkrBgEEAaAyARQwNDAyBggrBgEF\n'+
	'BQcCARYmaHR0cHM6Ly93d3cuZ2xvYmFsc2lnbi5jb20vcmVwb3NpdG9yeS8wCAYG\n'+
	'Z4EMAQICMAkGA1UdEwQCMAAwSQYDVR0fBEIwQDA+oDygOoY4aHR0cDovL2NybC5n\n'+
	'bG9iYWxzaWduLmNvbS9ncy9nc29yZ2FuaXphdGlvbnZhbHNoYTJnMi5jcmwwLQYD\n'+
	'VR0RBCYwJIIRKi5zdW5zdGFyLXNob3AuanCCD3N1bnN0YXItc2hvcC5qcDAdBgNV\n'+
	'HSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwHQYDVR0OBBYEFIQh83q36SPiEnNi\n'+
	'qa6kaC3DaBd3MB8GA1UdIwQYMBaAFJbeYfG9HBYpUxzAzH07gwBA5hp8MIIBAwYK\n'+
	'KwYBBAHWeQIEAgSB9ASB8QDvAHYAh3W/51l8+IxDmV+9827/Vo1HVjb/SrVgwbTq\n'+
	'/16ggw8AAAFk1RUVJAAABAMARzBFAiEAoWzI+RVYfMBryaCaGi42wGspg35ryzEm\n'+
	'o6Mnltsos18CIAPB3ccNbnHCQwkND+zhBrHqgtABo1wwwH+WU6AjatiFAHUApLkJ\n'+
	'kLQYWBSHuxOizGdwCjw1mAT5G9+443fNDsgN3BAAAAFk1RUVyAAABAMARjBEAiBo\n'+
	'rg71IweCF11vZrObdbriz3H/mPPYE4GPFpzF2dYT6wIgWpnUKJkgMGGOGu+zeYKq\n'+
	'g3TiZ/H7/54+r2BhfjME0jkwDQYJKoZIhvcNAQELBQADggEBALhkIM1iuYVSzihi\n'+
	'z4czMkqs0eBc6J8+JlFAFdDWLKBqWbLGUJdBHw4KIqqRn0MNXjxpzbnrphIojNdV\n'+
	'gqalhNal6beEV1QTtnzWESEYN4Ki7CkMN61jhtk9njC62mZ27svB7UUXPtyiIJU8\n'+
	'vkmQl22An/2OSCc0S3NEutYCtxeBB6iQWLn5Jlwqr9A0TcoPfx+3BGDneL/7BaJ4\n'+
	'ifnFzS+MGIuujL1ye/ftsLdK9Gdw/oZukFICfMXhzXvSf/5IPlrwQmxCxeLHA4RM\n'+
	'twafFSQAKg+SmkJlvnolh7SO5L0VyMlvObJEj9iqQiDG/VBh5eGVTvjyV3E5kcfQ\n'+
	'PBp7YqI=\n'+
	'-----END CERTIFICATE-----\n';
/*
 * read pem
 */
function selectType(id) {
	var pem = document.getElementById('pem');
	
	switch(id) {
	case 'your_pem':
		pem.value = '';
		break;
		
	case 'ov':
		pem.value = ov;
		break;
		
	case 'ev':
		pem.value = ev;
		break;
	}
}

var uniqueIndex = 0;
function readPem() {

	var cert_pem = document.getElementById('pem').value;
	if(cert_pem === '') {
		alert('enter PEM');
		return;
	}
	
	//var cards = ['subject_card', 'extension_card', 'simple_san_card'];
	
	var fields = ['sbj_cards_field', 'ext_cards_field', 'san_cards_field'];
	
	clearField(fields);
	clearCsr();
	switchDisplayValue('visible');
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				
				var obj = JSON.parse(xhr.responseText);
				
				var sbj = JSON.parse(obj.subjectJson);
				
				var parentWin = window.opener;
				
				showSubject(sbj, 'sbj_cards_field', parentWin);
			
				var extRequest = JSON.parse(obj.extJson);
				var ext = extRequest.otherExtHolder;
			
				showExtension(ext, 'ext_cards_field', parentWin);
				
				var san = extRequest.subjectAltName;

				showSan(san, 'san_cards_field', parentWin);
				
				//window.close();
				
			}
		}
	};
	
	var param = 'pem=' + encodeURIComponent(cert_pem);
	var url = '/readPem';
	
	xhr.open('POST', url, true);
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');
	xhr.send(param);
}
/*
 * 1. create sbj_cards_field
 * 2. create cards
 * 3. append them to sbj_cards_field
 */
function showSubject(sbj, parentId, parentWin) {
	if (sbj.length == 0) {
		return;
	}	
	
	var field = parentWin.document.createElement('div');
	field.id = parentId;
	parentWin.document.getElementById('subject_drag').appendChild(field);
	
	for (var i = 0; i < sbj.length; i++) {
		
		var e = parentWin.document.createElement('div');
		var id = sbj[i].dn + parentWin.uniqueIndex;
		e.className = 'subject_card';
		e.id = id;
		/*
		e.onmouseover = function () {
			addDnDEvent();
		}
		*/
		e.draggable = 'true';
		e.ondragover = function(event) {
			dragover(event);
		};
		e.ondragstart = function (event) {
			dragstart(event);
		};
		
		e.ondrop = function(event) {
			drop(event);
		};
		

		var dn = `<p class="subject_dn">${sbj[i].dn}</p>`;
		var textbox = `<input type="text" class="subject_value" value="${sbj[i].value}" style="width: 200px;">`;
		
		var deleteBtn = `<button class="delete_btn" name=${id} onclick="deleteCard(name);">×</button>`;
		
		e.innerHTML = dn + deleteBtn + textbox;
		parentWin.document.getElementById(parentId).appendChild(e); 
		//parentId = subject_drag -> "sbj_cards_firld"
		parentWin.uniqueIndex++;
	}
}

function showExtension(ext, parentId, parentWin) {
	if (ext === null) {
		return;
	}
	
	var field = parentWin.document.createElement('div');
	field.id = parentId;
	parentWin.document.getElementById('extension_drag').appendChild(field);
	

	for (var i = 0; i < ext.length; i++) {
		var e = document.createElement('div');
		var id = ext[i].oid
		e.className='extension_card';
		var id = id + parentWin.uniqueIndex;
		e.id = id;
		e.draggable = "true";
		e.ondragover = function(event) {
			dragover(event);
		};
		e.ondragstart = function(event) {
			dragstart(event);
		};
		
		e.ondrop = function(event) {
			drop(event);
		};
		var critical = ext[i].critical;
		
		var oid = `<p class="extension_oid">${ext[i].oid} / Critical: ${critical}</p>`; 
		var textarea = `<textarea class="extension_value" value="${ext[i].value}">${ext[i].value}</textarea>`;	
		var deleteBtn = `<button class="delete_btn" name=${id} onclick="deleteCard(name);">×</button>`;
		e.innerHTML = oid + deleteBtn + textarea;
		parentWin.document.getElementById(parentId).appendChild(e); 
		
		parentWin.uniqueIndex++;
	}
}

function showSan(san, parentId, parentWin) {
	if (san === null) {
		return;
	}
	
	var field = parentWin.document.createElement('div');
	field.id = parentId;
	parentWin.document.getElementById('san_drag').appendChild(field);
	
	
	var simple = san.simpleSanHolder;
	var nonSimple = san.nonSimpleSanHolder;
	for (var i in simple) {
		var type = simple[i].type
		var value = simple[i].value
		var e = document.createElement('div');
		var id = simple[i].type + parentWin.uniqueIndex;
		e.className = "simple_san_card";
		e.id = id;
		e.draggable = "true";
		e.ondragover = function(event) {
			dragover(event);
		};
		
		e.ondragstart = function(event) {
			dragstart(event);
		};
		
		e.ondrop = function(event) {
			drop(event);
		};
		var type = `<p class="san_type">${simple[i].type}</p>`;
		var textbox = `<input type="text" class="san_value" value="${simple[i].value}" style="width: 200px;">`;
		var deleteBtn = `<button class="delete_btn" name=${id} onclick="deleteCard(name);">×</button>`;
		e.innerHTML = type + deleteBtn + textbox;
		parentWin.document.getElementById(parentId).appendChild(e);
		
		parentWin.uniqueIndex++;
		
	}
	for ( var i in nonSimple) {
		
	}
}

const map = {
		'subject_card'    : 'subject_drop',
		'extension_card'  : 'extension_drop',
		'simple_san_card' : 'san_drop'
};

function addAllCards(className) {
	
	if (className === null) {
		for (var key in map) {
			var id = map[key];
			var elems = document.getElementsByClassName(key);
			var len = elems.length;
			for (var i=0; i < len; i++) {
				var card = elems[i];
				document.getElementById(id).appendChild(card);
			}
		}
		return;
	}
	
	var elems = document.getElementsByClassName(className);
	
	var id = map[className];

	var len = elems.length;
	for (var i=0; i < len; i++) {
		var card = elems[i];
		document.getElementById(id).appendChild(card);
	}
}

function openWindow() {
	var url = '/field';
	window.open(url, "sub window", "width=450,height=450,scrollbars=yes");
}

/*
 * generate CSR
 */

var Request = function(sbjHolder, extRequest, pkRequest) {
	this.sbjHolder = sbjHolder;
	this.extRequest = extRequest;
	this.pkRequest = pkRequest;
}

var Subject = function(dn, value) {
	this.dn = dn;
	this.value = value;
}

var ExtensionRequest = function (otherExtHolder, subjectAltName) {
	this.otherExtHolder = otherExtHolder;
	this.subjectAltName = subjectAltName;
}

var OtherExtension = function(oid, critical, value) {
	this.oid = oid;
	this.critical = critical;
	this.value = value;
}

var SubjectAltName = function(simpleSanHolder, nonSimpleSanHolder) {
	this.simpleSanHolder = simpleSanHolder;
	this.nonSimpleSanHolder = nonSimpleSanHolder;
}

var GeneralNameRequest = function(type, value) {
	this.type = type;
	this.value = value;
}
/*
 * object for handling publickey
 */
var PublicKeyRequest = function(spec, publicKeyPem) {
	this.spec = spec;
	this.publicKeyPem = publicKeyPem;
}

var Spec = function(rsa, ec) {
	this.rsa = rsa;
	this.ec = ec;
}

var RSA = function(keySize) {
	this.keySize = keySize;
}

var EC = function(curveName) {
	this.curveName = curveName;
}

var PublicKeyPem = function(publicKeyPem) {
	this.publicKeyPem = publicKeyPem;
}

function generateCsr() {
	
	const sbjHolder = createHolder('subject_card', Subject);
	if (sbjHolder === null) {
		return;
	}
	const pkRequest = createPublickeyRequest('publickey_card', PublicKeyRequest)
	if (pkRequest === null) {
		return;
	}
	
	const extHolder = createHolder('extension_card', OtherExtension);
	const simpleSanHolder = createHolder('simple_san_card', GeneralNameRequest);
	const nonSimpleSanHolder = createHolder('non_simple_san_card', GeneralNameRequest);
	const sanObj = new SubjectAltName(simpleSanHolder, nonSimpleSanHolder);
	const extRequest = new ExtensionRequest(extHolder, sanObj);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState  === 4) {
			if (xhr.status === 200) {
				
				switchDisplayValue('hidden');
				
				var obj = JSON.parse(xhr.responseText);
				var csr = obj.pem;
				
				var fields = ['sbj_cards_field', 'ext_cards_field', 'san_cards_field'];
				
				clearField(fields);
				clearCsr();
				showCsr(csr);
				
			}else {
				
			}
		}else {
		
		}
	};
	
	const request = new Request(sbjHolder, extRequest, pkRequest)

	var param = 'request=' + JSON.stringify(request);
	var url = '/generateCsr';
	
	xhr.open('POST', url, true);
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');

	xhr.send(param);
}

function showCsr(csr) {	
	
	const csrField = document.getElementById('csr_field');
	csrField.style.display = 'block';
	
	const e = document.createElement('textarea');
	e.id = 'csr';
	e.innerHTML = csr;
	document.getElementById('csr_field').appendChild(e);
}

function createHolder(cardClassName, Object) {
	
	const dropField = document.getElementById('drop_field');
	const cards = dropField.getElementsByClassName(cardClassName);

	if (cardClassName === 'subject_card' && cards.length === 0) {
		alert('add Subject');
		return null;
	}
	const holder = [];

	for (var i=0; i < cards.length; i++) {
		
		var card = cards[i];
		
		var key = null;
		
		var value = null;

		if (card.className === 'extension_card') {
			
			key = card.getElementsByTagName('p')[0].innerText.split(" / ")[0];
			critical = card.getElementsByTagName('p')[0].innerText.split(" / ")[1].split(": ")[1];
			value = card.getElementsByTagName('textarea')[0].value;
			holder.push( new Object(key, critical, value));

		} else {
			
			key = card.getElementsByTagName('p')[0].innerText;
			value = card.getElementsByTagName('input')[0].value;
			holder.push( new Object(key, value) );
		}
		
	}
	return holder;
}

function createPublickeyRequest(idName, Object) {
	
	var dropField = document.getElementById('publickey_drop');
	if (dropField.getElementsByClassName('publickey_card').length === 0) {
		alert('add public key');
		return;
	}
	
	
	const card = document.getElementById(idName);
	var type = card.getElementsByTagName('p')[0].innerText;
	/*
	var curveName = card.getElementsByTagName('input')[0].value;
	var keySize = card.getElementsByTagName('input')[0].value;
	*/
	/*
		var PublicKeyRequest = function(spec, publicKey) {
			this.spec = spec;
			this.publicKey = publicKey;
		}
		
		var Spec = function(rsa, ec) {
			this.rsa = rsa;
			this.ec = ec;
		}
		
		var RSA = function(keySize) {
			this.keySize = keySize;
		}
		
		var EC = function(keySize, curveName) {
			this.keySize = keySize;
			this.curveName = curveName;
		}
		
		var PublicKey = function(publicKey) {
			this.publicKey = publicKey;
		}
	 */
	if (type === "RSA") {
		var value = card.getElementsByTagName('input')[0].value;
		var rsa = new RSA(value);
		var spec = new Spec(rsa, null);
		
		var publicKeyRequest = new PublicKeyRequest(spec, null);
		
	} else if(type === "EC") {
		var value = card.getElementsByTagName('input')[0].value;
		var ec = new EC(value);
		var spec = new Spec(null, ec);
		
		var publicKeyRequest = new PublicKeyRequest(spec, null);
		
	} else if(type === "Public Key") {
		var value = card.getElementsByTagName('textarea')[0].value;
		var replacedValue = value.replace(/\n/g, '\\n');
		var encodedValue = encodeURIComponent(replacedValue);
		var publicKey = new PublicKeyPem(encodedValue);
		
		var publicKeyRequest = new PublicKeyRequest(null, publicKey);
	}

	return publicKeyRequest;
}

function addCard(self, name) {
	
	const m = {
			'subject_drop'  : 0,
			'extension_drop': 1,
			'san_drop'      : 2,
			'publickey_drop': 3
	};
	
	var e = document.createElement('div');
	
	switch(name) {
	case 'subject_drop':
		
		var key = self.parentNode.getElementsByTagName('input')['key'].value;
		if (key === '') {
			alert('enter DN');
			return;
		}
		
		var value =  self.parentNode.getElementsByTagName('input')['value'].value;
		e.className = 'subject_card';
		
		var keyField = `<p class="subject_dn">${key}</p>`;
		var valueField = `<input type="text" class="subject_value" value="${value}" style="width: 200px;">`;
		
		break;
		
	case 'extension_drop':
		var key = self.parentNode.getElementsByTagName('input')['key'].value;
		var select = self.parentNode.getElementsByTagName('select')['key'];
		var index = select.selectedIndex;
		var critical = select.options[index].text;
		
		if (key === '') {
			alert('enter OID');
			return;
		}
		var value =  self.parentNode.getElementsByTagName('textarea')['value'].value;
		e.className='extension_card';
		
		var keyField = `<p class="extension_oid">${key} / Critical: ${critical}</p>`; 
		var valueField = `<textarea class="extension_value" value="${value}">${value}</textarea>`;	

		break;
		
	case 'san_drop':
		var select = self.parentNode.getElementsByTagName('select')['key'];
		var index = select.selectedIndex;
		var key = select.options[index].text;
		
		if (index === 4) {
			var value =  self.parentNode.getElementsByTagName('input')['dn_value'].value;
		} else {
			var value =  self.parentNode.getElementsByTagName('input')['value'].value;
		}
		
		if (index === 7 && value === "") {
			alert('IPAdress can not be null');
			return;
			
		} else if (index === 8 && value === ""){
			alert('registerdID can not be null');
			return;
		}
		
		if ( (index == 0 || index == 3 || index == 5) ) {
			e.className = 'non_simple_san_card';
		} else {
			e.className = 'simple_san_card';
		}
		
		var keyField = `<p class="san_type">${key}</p>`;
		var valueField = `<input type="text" class="san_value" value="${value}" style="width: 200px;">`;
		
		break;
		
	case 'publickey_drop':
		break;
	}
	var id = key + uniqueIndex;
	e.id = id;
	e.draggable = 'true';
	e.ondragover = function(event) {
		dragover(event);
	};
	e.ondragstart = function(event) {
		dragstart(event);
	}
	e.ondblclick = function(event) {
		removeCard(event);
	};
	var deleteBtn = `<button class="delete_btn" name=${id} onclick="deleteCard(name);">×</button>`;
	e.innerHTML = keyField + deleteBtn + valueField;

	document.getElementById(name).appendChild(e); 
	var i = m[name];
	document.forms[i].reset();
	uniqueIndex++;
}

function addPublicKey(form, formChooseAlgorithm) {
	
	var dropField = document.getElementById('publickey_drop');
	if (dropField.getElementsByClassName('publickey_card').length !== 0) {
		alert('accept only One public key');
		return;
	}
	
	switch (form.name) {
	case 'add_publickey_spec':
		
		var radioBtn = formChooseAlgorithm.elements;
		for ( var i in radioBtn) {
			
			if (radioBtn[i].checked === false) {
				continue;
			}
			
			switch(radioBtn[i].value) {
			case 'RSA':
				var publickeySize = form.getElementsByTagName('input')['publickey_size'].value;
				if ( Number(publickeySize) < 512 ) {
					alert('RSA keys must be at least 512 bits long');
					return;
				} else if ( Number(publickeySize) > 16384) {
					alert('RSA keys must be no longer than 16384 bits');
					return;
				}
				
				var keyField = `<p class="extension_oid">RSA</p>`; 
				var valueField = `<input type="text" class="publickey_size_value" value="${publickeySize}" style="width: 200px;">`;
				
				break;
				
			case 'EC':
				var keyField = `<p class="extension_oid">EC</p>`; 
				var select = form.getElementsByTagName('select')['curve_name'];
				var index = select.selectedIndex;
				var curveName = select.options[index].text;
				var valueField = `<input type="text" class="publickey_value" value="${curveName}" style="width: 200px;">`;
				
				break;	
			}	
		}
		document.forms[4].reset();
		break;
		
	case 'add_publickey':
		var value =  form.getElementsByTagName('textarea')['value'].value;
		var keyField = `<p class="extension_oid">Public Key</p>`; 
		var valueField = `<textarea class="publickey_textarea_value" value="${value}">${value}</textarea>`;	
		document.forms[5].reset();
		
		break;
	}
	
	var e = document.createElement('div');
	e.className = 'publickey_card';
	
	var id = 'publickey_card';
	e.id = id;
	
	e.draggable = 'true';
	e.ondragover = function(event) {
		dragover(event);
	};
	e.ondragstart = function(event) {
		dragstart(event);
	}
	e.ondblclick = function(event) {
		removeCard(event);
	};
	var deleteBtn = `<button class="delete_btn" name=${id} onclick="deleteCard(name);">×</button>`;
	e.innerHTML = keyField + deleteBtn + valueField;
	
	dropField.appendChild(e); 	
}

function deleteCard(id) {
	var e = document.getElementById(id);
	e.parentNode.removeChild(e);
}

function clearCsr() {
	var doc;
	
	if (window.opener == null) {
		doc = document;
	} else {
		doc = window.opener.document;
	}
	
	const csrField = doc.getElementById('csr_field');
	csrField.style.display = 'none';
	
	var e = doc.getElementById('csr');
	
	if (e === null) {
		return;
	}
	e.parentNode.removeChild(e);
}

function clearField(fields) {
	var doc;
	
	if (window.opener == null) {
		doc = document;
	} else {
		doc = window.opener.document;
	}
	
	for (var i in fields) {
		var field = fields[i];
		
		var e = doc.getElementById(field);
		
		if (e === null) {
			continue;
		}

		e.parentNode.removeChild(e);
	}
}

function switchDisplayValue(value) {
	
	var doc;
	
	if (window.opener == null) {
		doc = document;
	} else {
		doc = window.opener.document;
	}
	
	var elems = doc.getElementsByClassName('btn_add_all');
	
	for ( var i = 0; i < elems.length; i++) {
		elems[i].style.visibility = value;
	}
	
	var array = ['subject_drag', 'extension_drag', 'san_drag'];
	
	for (var i in array) {
		var dragField = array[i];
		console.log(dragField);
		doc.getElementById(dragField).style.visibility = value;
	}
}

function dragover(event) {
	console.log("dragover: called");
	event.preventDefault();
}

function dragstart(event) {
	console.log('dragstart: called');
	var data = { 'id': event.target.id, 'className': event.target.className };
	var json = JSON.stringify(data);
	event.dataTransfer.setData("data", json);
}

function drop(event) {
	console.log('drop: called');
	var json = event.dataTransfer.getData('data');
	var data = JSON.parse(json);
	
	var className = data.className;
	var dragId = data.id;
	
	var dropId = map[className];
	
	var e = document.getElementById(dragId);
	document.getElementById(dropId).appendChild(e);
}

function changeDisplayValue(thisDiv, anotherDiv) {
	
	function makeDisplayNone(thisValue, anotherValue) {
		thisDiv.style.display = thisValue;
		anotherDiv.style.display = anotherValue;
	}
	
	function changeAddBtnDisplayValue(value_for_btn_spec, value_for_btn_key) {
		document.getElementById('btn_spec').style.display = value_for_btn_spec;
		document.getElementById('btn_key').style.display = value_for_btn_key;
	}
	
	switch(thisDiv.id) {
	case 'publickey_spec':
		makeDisplayNone('block', 'none');
		changeAddBtnDisplayValue('block', 'none');
		break;
		
	case 'publickey_key':
		makeDisplayNone('block', 'none');
		changeAddBtnDisplayValue('none', 'block');
		break;
		
	//RSA
	case 'publickey_size':
		makeDisplayNone('block', 'none');
		break;
		
	//ECC
	case 'curve_name':
		makeDisplayNone('block', 'none');
		break;
	}
}

function showSelectBoxForCurvName() {
	let ec = document.add_publickey_spec.elements[1];
	
	if (ec.checked == true) {
		document.getElementById('curve_name').style.display = 'block';
	} else {
		document.getElementById('curve_name').style.display = 'none';
	}
}
