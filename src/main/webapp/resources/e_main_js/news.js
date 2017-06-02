
document.domain='naver.com';
var _MAIN_NEWS_MENU_ID='shm';
var _MAIN_NEWS_SECTION_ID='103';
var ccsrv='cc.naver.com';
var nsc='news.science';
var gnb_service='news';
var gnb_logout='http://news.naver.com';
var gnb_template='gnb_euckr';
var gnb_brightness = 1;
var gnb_one_naver = 1;
var gnb_searchbox='on';
var gnb_shortnick='on';

var gnb_timestamp = "2017042714";

window.onload = function() {
	var selected_item = jindo.$('_');
	if (selected_item != null) {
		selected_item.className = "highlight";
		news.section.ScrollingManager.scroll('');
	}
}

news.section.MainIssueCollectManager.init();
news.section.IssueKeywordManager.init();
news.util.CommentListCountManager.view();

var ranking_selectedSectionId = '';
var ranking_listAllSection = jindo.$A(['000', '100', '101', '102', '103', '104', '105', '106', '107']);
var ranking_listPrevSection = ranking_listAllSection.slice(0,5);
function ranking_switch_category(event) {
if (jindo.$Element('right.ranking_category_a').visible()) {
ranking_select_section('104');
} else {
ranking_select_section('000');
}
}
jindo.$A(['prev', 'next']).forEach( function (v, i, o) {
jindo.$Fn(ranking_switch_category, window).attach(jindo.$Element(jindo.$('right.ranking_btn_' + v)), 'click');
});
function ranking_select_tab(sectionId) {
if (ranking_listPrevSection.has(sectionId)) {
jindo.$Element('right.ranking_category_b').hide();
jindo.$Element('right.ranking_category_a').show();
} else {
jindo.$Element('right.ranking_category_a').hide();
jindo.$Element('right.ranking_category_b').show();
}
jindo.$('right.ranking_tab_' + sectionId).innerHTML = "<strong>" + ranking_select_section_name(sectionId) + "</strong>";
jindo.$Element('right.ranking_tab_' + sectionId).addClass('is_click');
if (ranking_selectedSectionId) {
jindo.$('right.ranking_tab_' + ranking_selectedSectionId).innerHTML = ranking_select_section_name(ranking_selectedSectionId);
jindo.$Element('right.ranking_tab_' + ranking_selectedSectionId).removeClass('is_click');
}
ranking_selectedSectionId = sectionId;
}
function ranking_select_section(sectionId) {
if (!ranking_listAllSection.has(sectionId)) {
sectionId = '000';
}
jindo.$('right.ranking_contents').innerHTML = jindo.$('ranking_' + sectionId).innerHTML;
ranking_select_tab(sectionId);
}
function ranking_select_section_name(sectionId) {
var selectSectionName = "종합";
switch (sectionId) {
case '100' : selectSectionName = "정치"; break;
case '101' : selectSectionName = "경제"; break;
case '102' : selectSectionName = "사회"; break;
case '103' : selectSectionName = "생활/문화"; break;
case '104' : selectSectionName = "세계"; break;
case '105' : selectSectionName = "IT/과학"; break;
case '106' : selectSectionName = "TV연예"; break;
case '107' : selectSectionName = "스포츠"; break;
default : selectSectionName = "종합" ;
}
return selectSectionName;
}
function ranking_tab_handler(event) {
var sectionId = jindo.$Event(event).element.id.replace('right\.ranking_tab_', '');
if (sectionId) {
ranking_select_section(sectionId);
}
}
ranking_listAllSection.forEach(function (v, i, o) {
jindo.$Fn(ranking_tab_handler, window).attach(jindo.$Element(jindo.$('right.ranking_tab_' + v)), 'mouseover');
});
ranking_select_section('201');

var rightDailyList = {
id : 'right_dailyList',
init : function() {
this.tabList = jindo.$A(jindo.$$('#' + this.id + ' div.category a'));
this.contentsList = jindo.$A(jindo.$$('#' + this.id + ' div.classfy'));
var randomIndex = this.getRandomIndex();
this.toggle(randomIndex);
jindo.$Fn(this.handler, this).attach(this.tabList, 'mouseover');
},
getRandomIndex : function() {
return Math.floor(Math.random() * this.tabList.length());
},
getSelectedIndex : function(el) {
var selectedIndex;
this.tabList.forEach(function(value, index, array) {
if (el.tagName === 'A' && value == el) {
selectedIndex = index;
} else if (el.tagName === 'STRONG' && value == el.parentNode) {
selectedIndex = index;
}
});
return selectedIndex;
},
handler : function(event) {
event.stopDefault();
var selectedIndex = this.getSelectedIndex(event.element);
if (this.currentIndex !== selectedIndex) {
this.toggle(selectedIndex);
}
},
toggle : function(selectedIndex) {
var self = this;
this.tabList.forEach(function(value, index, array) {
var wel = jindo.$Element(value);
if (selectedIndex === index) {
wel.html('<strong>' + wel.html() + '</strong>');
wel.addClass("is_click");
} else if (self.currentIndex === index) {
wel.html(wel.first().html());
wel.removeClass("is_click");
}
});
this.contentsList.forEach(function(value, index, array) {
var wel = jindo.$Element(value);
if (selectedIndex === index) {
wel.show();
} else {
wel.hide();
}
});
this.currentIndex = selectedIndex;
}
}
rightDailyList.init();

new news.lnb.NewsSearchController('lnb.searchForm');



var lnb_weatherRolling = new news.lnb.LineRolling('lnb.weather',{size:26,moveSize:3,moveInterval:30});
var lnb_mainnewsRolling = new news.lnb.LineRolling('lnb.mainnews',{size:17,moveSize:2,moveInterval:30,isRandomStart:true});
var lnb_Rolling = new news.lnb.SynchronizedRolling({interval:3000});
lnb_Rolling.push(lnb_weatherRolling);
lnb_Rolling.push(lnb_mainnewsRolling);
lnb_Rolling.start();


var index_tab = new news.index.TabController('index.press_category');
index_tab.add(new news.index.Tab('index.press.btn','stit','index.press.area','/main/ajax/bottomIndex/press.nhn'));
index_tab.add(new news.index.Tab('index.category.btn','stit2','index.category.area','/main/ajax/bottomIndex/category.nhn'));
jindo.$Fn(index_tab.toggle, index_tab).attach(index_tab.tabs.keys(), 'click');


(function() {
	news.right.RightSideFloatingManager.init();
})();
	
	lcs_do();

news.startup();


jindo.$Fn(function(){
    var welSkip = jindo.$Element("u_skip");
    if (welSkip === null) {
        return;
    }
    welSkip.delegate("click", "a", function(weEvent){
        weEvent.stopDefault();
        var elTarget = jindo.$(weEvent.element.href.split("#")[1]);
        oWebAccessibilityUtil.moveFocus(elTarget);
    });
}).attach(window, "load");


document.documentElement.setAttribute('data-useragent',navigator.userAgent);
