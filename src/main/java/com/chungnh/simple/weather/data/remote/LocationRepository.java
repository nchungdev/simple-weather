package com.chungnh.simple.weather.data.remote;

import com.chungnh.simple.weather.data.local.LocationDbRepository;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.utility.task.Observable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {
    private final LocationDbRepository dbRepository;

    public LocationRepository(LocationDbRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public Observable<List<Location>> search(String name) {
        List<Location> locations = dbRepository.search(name);
        if (!locations.isEmpty())
            return Observable.fromCallable(() -> locations);
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("count", "10"));
        nameValuePairs.add(new BasicNameValuePair("language", "en"));
        nameValuePairs.add(new BasicNameValuePair("format", "json"));
        return RestApi.searchLocation(nameValuePairs);
    }

    public Observable<Location> getRecentLocation() {
        return Observable.fromCallable(dbRepository::getLastLocation);
    }
}
