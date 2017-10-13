package chocobos;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	ChocoboStatsTests.class,
	ChocoboTests.class,
	RentalTests.class,
	StableTests.class,
	StableFoodStoresTests.class
})

public class TestDriver {
}
