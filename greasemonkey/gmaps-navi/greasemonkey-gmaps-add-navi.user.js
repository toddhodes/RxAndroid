// ==UserScript==
// @name          gmaps-add-navi
// @description	  rewrite addresses to be navi:// links
// @include       http://maps.google.com/*
// @include       http://*.maps.google.com/*
// @include       http://local.google.com/*
// ==/UserScript==

//var timer;


/** add a navi link based on, and beside, these:
 * <span id="sxaddr" class="adr" dir="ltr">
 * <span class="street-address">1366 Powell St</span>,
 * <span class="locality">Emeryville</span>,
 * <span class="region">CA</span>
 * </span>
 */
function doReplace() {
    var addrs = new Array();
    var links = new Array();

    var iterator = document.evaluate('//*[@id="sxaddr"]', document, null,
                                   XPathResult.UNORDERED_NODE_ITERATOR_TYPE, null);

    try {
        var thisNode;
        var i = 0;

        while (thisNode = iterator.iterateNext()) {
            if (thisNode.getAttribute("madeNavi") == "t") {
              break;
            }

            addrs[i] = thisNode;
            links[i] = thisNode.childNodes[0].firstChild.nodeValue;
            links[i] = links[i] + "," + thisNode.childNodes[2].firstChild.nodeValue;
            links[i] = links[i] + "," + thisNode.childNodes[4].firstChild.nodeValue;
            i++;
        }
    } catch (e) {
      //alert('Error: Document tree modified during iteration ' + e);
    }

    var x;
    for  (x in addrs) {
        addrs[x].innerHTML = addrs[x].innerHTML
                             + "&nbsp;<a href=\"navi://" + links[x]
                             + "\">Navigate here</a>";
        addrs[x].setAttribute("madeNavi", "t");
    }

    //clearInterval(timer);
    //timer = setInterval(doReplace, 6000);
}

/** add a doReplace hook to ajax submit
 */
function addHook() {
  document.addEventListener('DOMNodeInserted',
                             function() { window.setTimeout(doReplace, 3000);}, true);
  //var qform = document.evaluate('//*[@id="q_form"]', document, null,
  //                              XPathResult.FIRST_ORDERED_NODE_TYPE, null);
  //qform.singleNodeValue.action = "return onSearch(this)";
}

addHook();
doReplace();

