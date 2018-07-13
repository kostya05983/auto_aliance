package com.it_zoo.kostya05983.auto_aliance.Franchising

data class DataFranchisinGrid(val Title: String, val SubTitle: String?, val sectionFirst: MutableList<String>?, val additionBetwenSections: String?, val sectionSecond: MutableList<String>?, val PaushPrice: String?, /*для пакета инвестор*/ val listInfoInvestor: MutableList<String>?, val FixPrice: String?, val additionInfo: String? ) {

}