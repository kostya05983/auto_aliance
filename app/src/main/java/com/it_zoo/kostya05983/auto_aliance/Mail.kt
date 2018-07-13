package com.it_zoo.kostya05983.auto_aliance

import java.util.*
import javax.activation.CommandMap
import javax.mail.internet.MimeMessage
import javax.mail.internet.InternetAddress
import javax.activation.CommandMap.setDefaultCommandMap
import javax.activation.CommandMap.getDefaultCommandMap
import javax.activation.DataHandler
import javax.activation.FileDataSource
import javax.activation.MailcapCommandMap
import javax.mail.*
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart
import javax.xml.transform.OutputKeys.ENCODING


class Mail :Authenticator() {
    private var _user: String? = null
    private var _pass: String? = null

    private var _to: Array<String>? = null
    private var _from: String? = null

    private var _port: String? = null
    private var _sport: String? = null

    private var _host: String? = null

    private var _subject: String? = null
    private var _body: String? = null

    private var _auth: Boolean = false

    private var _debuggable: Boolean = false

    private var _multipart: Multipart? = null

    init {
        _host = "smtp.yandex.ru" // default smtp server
        _port = "465" // default smtp port
        _sport = "465" // default socketfactory port

        _user = "avtoalians.org@yandex.ru" // username
        _pass = "qaz123wsx456" // password
        _from = "avtoalians.org@yandex.ru" // email sent from
        _subject = "Заказ" // email subject

        _debuggable = false // debug mode on or off - default off
        _auth = true // smtp authentication - default on

        _multipart = MimeMultipart()

        // There is something wrong with MailCap, javamail can not find a
        // handler for the multipart/mixed part, so this bit needs to be added.
        val mc = CommandMap
                .getDefaultCommandMap() as MailcapCommandMap
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html")
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml")
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain")
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed")
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822")
        CommandMap.setDefaultCommandMap(mc)
    }


    @Throws(Exception::class)
    fun send(message:String): Boolean {
        _body = message
        val props = _setProperties()

        if (_user != "" && _pass != "" && _to!!.size > 0
                && _from != "" && _subject != ""
                && _body != "") {
            val session = Session.getInstance(props, this)

            val msg = MimeMessage(session)

            msg.setFrom(InternetAddress(_from!!))

            val addressTo = arrayOfNulls<InternetAddress>(_to!!.size)
            for (i in _to!!.indices) {
                addressTo[i] = InternetAddress(_to!![i])
            }
            msg.setRecipients(MimeMessage.RecipientType.TO, addressTo)
            msg.subject = _subject


            msg.sentDate = Date()
            msg.setText(_body)

            Transport.send(msg)

            return true
        } else {
            return false
        }
    }

    @Throws(Exception::class)
    fun addAttachment(filename: String) {
        val messageBodyPart = MimeBodyPart()
        val source = FileDataSource(filename)
        messageBodyPart.setDataHandler(DataHandler(source))
        messageBodyPart.setFileName(filename)

        _multipart!!.addBodyPart(messageBodyPart)
    }

    public override fun getPasswordAuthentication(): PasswordAuthentication {
        return PasswordAuthentication(_user, _pass)
    }

    private fun _setProperties(): Properties {
        val props = Properties()

        props["mail.smtp.port"] = _port
        props["mail.smtp.host"] = _host

        if (_debuggable)
            props["mail.debug"] = "true"


        if (_auth)
            props["mail.smtp.auth"] = "true"



        props["mail.smtp.socketFactory.port"] = _sport
        props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
        props["mail.smtp.starttls.enable"] = "true"
        //props["mail.smtp.socketFactory.fallback"] = "false"
        props["mail.mime.charset"] = ENCODING

        return props
    }

    // the getters and setters
    fun getBody(): String? {
        return _body
    }

    fun setBody(_body: String) {
        this._body = _body
    }

    fun get_user(): String? {
        return _user
    }

    fun set_user(_user: String) {
        this._user = _user
    }

    fun get_pass(): String? {
        return _pass
    }

    fun set_pass(_pass: String) {
        this._pass = _pass
    }

    fun get_to(): Array<String>? {
        return _to
    }

    fun set_to(_to: Array<String>) {
        this._to = _to
    }

    fun get_from(): String? {
        return _from
    }

    fun set_from(_from: String) {
        this._from = _from
    }

    fun get_port(): String? {
        return _port
    }

    fun set_port(_port: String) {
        this._port = _port
    }

    fun get_sport(): String? {
        return _sport
    }

    fun set_sport(_sport: String) {
        this._sport = _sport
    }

    fun get_host(): String? {
        return _host
    }

    fun set_host(_host: String) {
        this._host = _host
    }

    fun get_subject(): String? {
        return _subject
    }

    fun set_subject(_subject: String) {
        this._subject = _subject
    }

    fun is_auth(): Boolean {
        return _auth
    }

    fun set_auth(_auth: Boolean) {
        this._auth = _auth
    }

    fun is_debuggable(): Boolean {
        return _debuggable
    }

    fun set_debuggable(_debuggable: Boolean) {
        this._debuggable = _debuggable
    }

    fun get_multipart(): Multipart? {
        return _multipart
    }

    fun set_multipart(_multipart: Multipart) {
        this._multipart = _multipart
    }
}