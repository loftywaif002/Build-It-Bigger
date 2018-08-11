package com.cmpny.wca.jokeslibrary;



import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MyJokes {

    List<String> jokes  = asList(
         "Moses had the first tablet that could connect to the cloud",
         "Alcohol is a perfect solvent: It dissolves marriages, families and careers.",
         "A doctor tells a woman she can no longer touch anything alcoholic. So she gets a divorce.",
         "Where there's a will, there's a relative.",
         "A lawyer-turned-cook is a sue chef",
         "How do construction workers party? They raise the roof.",
         "I slept like a log during the night shift and I was axed when I awoke!",
         "What would bears be without bees? Ears.",
         "What do you call bees that are fat? Obeese.",
         "What do you call a cow with two legs? Lean beef."
    );

    public String getRandomJokes(){
        Random random = new Random();
        String randomJoke = jokes.get(random.nextInt(jokes.size()));
        return  randomJoke;
    }
}
