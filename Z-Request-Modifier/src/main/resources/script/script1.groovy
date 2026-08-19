package script

/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;
//import java.util.HashMap;
import groovy.json.JsonSlurper;

def Message processData(Message message) {

    /*To set or modify the body, you can use the following methods.
    def body = message.getBody();
    message.setBody(body + " Body is modified");

    //To set or modify the headers, you can use the following methods.
    def headers = message.getHeaders();
    def value = headers.get("oldHeader");
    message.setHeader("oldHeader", value + " modified");
    message.setHeader("newHeader", "newHeader");

    //To set or modify the properties, you can use the following methods.
    def properties = message.getProperties();
    value = properties.get("oldProperty");
    message.setProperty("oldProperty", value + " modified");
    message.setProperty("newProperty", "newProperty"); */


    //def json = message.getBody(java.io.Reader);
    def json = message.getBody(java.lang.String);
    //def data  = new JsonSlurper().parse(json);

    def messageLog = messageLogFactory.getMessageLog(message)
    if (messageLog != null) {
        messageLog.addAttachmentAsString('My Attachment', json, 'text/plain')
    }

/*
    //get fields of the payload (service, ressource & id)
    message.setProperty("service", data.query.service);
    message.setProperty("resource", data.query.entity.name);
    message.setProperty("id", data.query.entity.id);
    //get columns to be read
    def numFields = data.query.entity.fields.size();
    def fields = "";
    for (int i=0; i<numFields; i++) {
        fields += data.query.entity.fields[i].name;
        if (i<numFields-1) fields += ",";
    }
    message.setProperty("fields", fields);

*/
    message.setBody( json );
    return message;
}