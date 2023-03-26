package src.weather;

import src.helper.Source;
import src.helper.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class Weather implements Source {

    private final List<Tag> tags = new ArrayList<>();

    @Override
    public boolean hasTag(Tag tag) {
        return tags.contains(tag);
    }

    @Override
    public void addTag(Tag tag) {
        tags.add(tag);
    }
}
