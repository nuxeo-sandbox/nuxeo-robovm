package org.nuxeo.robovm;

import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.ecm.automation.client.model.Document;

import java.util.Random;

public class NuxeoClient {

    private static final String API_URL = "https://nightly.nuxeo" +
            ".com/nuxeo/site/automation";

    protected Session session;

    public NuxeoClient() {
        HttpAutomationClient client = new HttpAutomationClient(API_URL);
        try {
            session = client.getSession("Administrator",
                    "Administrator");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class OnNuxeoListener {
        public void onClick(String title) {
        }
    }

    public void getDocumentTitle(final OnNuxeoListener listener) {
        Document root = null;
        String[] documents = { "/default-domain",
                "/default-domain/workspaces", "/default-domain/templates",
                "/default-domain/sections" };
        int index = new Random().nextInt(documents.length);
        String document = documents[index];
        try {
            root = (Document) session.newRequest("Repository.GetDocument")
                    .set("value", document).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listener.onClick(root.getTitle());
    }

}
