package com.greendao;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;


public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.faultaddr.greendaoapp.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"/home/pyy/PROJ/AccountingExpert/app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addDetailEntity(schema);
        // addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addDetailEntity(final Schema schema) {
        Entity detail = schema.addEntity("RecordDetail");
        detail.addIdProperty().primaryKey().autoincrement();
        detail.addStringProperty("detail");
        detail.addStringProperty("category");
        detail.addStringProperty("amount");
        detail.addStringProperty("account");
        detail.addStringProperty("date");
        detail.addDateProperty("timestamp");
        return detail;
    }

}