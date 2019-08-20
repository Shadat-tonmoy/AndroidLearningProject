package com.stcodesapp.quotes_einstein.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.stcodesapp.quotes_einstein.controllers.activityController.MainActivityController;
import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteInsertTask;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseNavigationDrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initQuotes();
        getQuotes();

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void getQuotes()
    {
        getCompositionRoot().getTasksFactory().getQuoteFetchingTask().execute();

    }

    private void initQuotes()
    {
        List<Quotes> quotes = new ArrayList<>();
        quotes.add(new Quotes("Any intelligent fool can make things bigger, more complex, and more violent. It takes a touch of genius, and a lot of courage to move in the opposite direction."));

        quotes.add(new Quotes("Gravitation is not responsible for people falling in love."));

        quotes.add(new Quotes("The hardest thing in the world to understand is the income tax."));

        quotes.add(new Quotes("I never think of the future. It comes soon enough."));

        quotes.add(new Quotes("Science without religion is lame. Religion without science is blind."));

        quotes.add(new Quotes("Great spirits have often encountered violent opposition from weak minds."));

        quotes.add(new Quotes("Everything should be made as simple as possible, but not simpler."));

        quotes.add(new Quotes("The secret to creativity is knowing how to hide your sources."));

        quotes.add(new Quotes("We can't solve problems by using the same kind of thinking we used when we created them."));

        quotes.add(new Quotes("Education is what remains after one has forgotten everything he learned in school."));

        quotes.add(new Quotes("Do not worry about your difficulties in Mathematics. I can assure you, mine are still greater."));

        quotes.add(new Quotes("Two things are infinite: the universe and human stupidity; and I'm not sure about the the universe."));

        quotes.add(new Quotes("I know not with what weapons World War III will be fought, but World War IV will be fought with sticks and stones."));

        quotes.add(new Quotes("In order to form an immaculate member of a flock of sheep one must, above all, be a sheep."));

        quotes.add(new Quotes("The fear of death is the most unjustified of all fears, for there's no risk of accident for someone who's dead."));

        quotes.add(new Quotes("The release of atom power has changed everything except our way of thinking… the solution to this problem lies in the heart of mankind. If only I had known, I should have become a watchmaker."));

        quotes.add(new Quotes("Not everything that counts can be counted, and not everything that can be counted counts."));

        quotes.add(new Quotes("Insanity is doing the same thing, over and over again, but expecting different results."));

        quotes.add(new Quotes("I am enough of an artist to draw freely upon my imagination. Imagination is more  important than knowledge. Knowledge is limited. Imagination encircles the world."));

        quotes.add(new Quotes("If you can't explain it to a six year old, you don't understand it yourself."));

        quotes.add(new Quotes("Logic will get you from A to Z; imagination will get you everywhere."));

        quotes.add(new Quotes("The most incomprehensible thing about the world is that it is comprehensible."));

        quotes.add(new Quotes("Common sense is the collection of prejudices acquired by age eighteen."));

        quotes.add(new Quotes("Try not to become just a man of success, but rather try to become a man of value."));

        quotes.add(new Quotes("It’s not that I’m so smart; it is just that I stay with problems longer."));

        quotes.add(new Quotes("Learn from yesterday, live for today, hope for tomorrow. The important thing is to not stop questioning."));

        quotes.add(new Quotes("I have no special talents. I am only passionately curious."));

        quotes.add(new Quotes("The person who never made a mistake never tried anything new."));

        quotes.add(new Quotes("Example isn’t another way to teach, it is the only way to teach."));

        quotes.add(new Quotes("If a cluttered desk is a sign of a cluttered mind, of what then, is an empty desk?"));

        quotes.add(new Quotes("The world is a dangerous place, not because of those who do evil, but because of those who look on and do nothing."));

        quotes.add(new Quotes("When the solution is simple, God is answering."));

        quotes.add(new Quotes("Money only appeals to selfishness and always tempts its owners irresistibly to abuse it. Can anyone imagine Moses, Jesus, or Gandhi armed with the money-bags of Carnegie?"));

        quotes.add(new Quotes("An empty stomach is not a good political adviser."));

        quotes.add(new Quotes("The difference between genius and stupidity is; genius has its limits."));

        quotes.add(new Quotes("Everybody is a genius. But if you judge a fish by its ability to climb a tree, it will live its whole life believing that it is stupid."));

        quotes.add(new Quotes("When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That's relativity."));

        quotes.add(new Quotes("A clever person solves a problem. A wise person avoids it."));

        quotes.add(new Quotes("If A is a success in life, then A equals x plus y plus z. Work is x; y is play; and z is keeping your mouth shut."));

        quotes.add(new Quotes("Men marry women with the hope they will never change. Women marry men with the hope they will change. Invariably they are both disappointed."));


        quotes.add(new Quotes("It would be possible to describe everything scientifically, but it would make no sense; it would be without meaning, as if you described a Beethoven symphony as a variation of wave pressure."));

        quotes.add(new Quotes("A ship is always safe at the shore - but that is NOT what it is built for."));

        quotes.add(new Quotes("If people are good only because they fear punishment, and hope for reward, then we are a sorry lot indeed."));

        quotes.add(new Quotes("Even on the most solemn occasions I got away without wearing socks and hid that lack of civilization in high boots."));

        quotes.add(new Quotes("A person starts to live when he can live outside himself."));

        quotes.add(new Quotes("It would be possible to describe everything scientifically, but it would make no sense; it would be without meaning, as if you described a Beethoven symphony as a variation of wave pressure."));

        quotes.add(new Quotes("Let every man be respected as an individual and no man idolized."));

        quotes.add(new Quotes("Technological change is like an axe in the hands of a pathological criminal."));

        quotes.add(new Quotes("The only justifiable purpose of political institutions is to ensure the unhindered development of the individual."));

        quotes.add(new Quotes("Work is the only thing that gives substance to life."));

        quotes.add(new Quotes("Never lose a holy curiosity."));

        quotes.add(new Quotes("When you look at yourself from a universal standpoint, something inside always reminds or informs you that there are bigger and better things to worry about."));

        quotes.add(new Quotes("Paper is to write things down that we need to remember. Our brains are used to think."));
        QuoteInsertTask quoteInsertTask = getCompositionRoot().getTasksFactory().getQuoteInsertTask();
        quoteInsertTask.execute(quotes);

    }
}
