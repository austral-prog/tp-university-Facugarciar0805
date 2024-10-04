package com.university.CsvWorker;

import java.util.List;

public interface ObjectCreator {
    Creatable createObject(String[] data);
}
