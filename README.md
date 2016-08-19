# Android-Espresso-ScrollableScroll
Espresso ViewAction to scroll in any ScrollableView implementation in Espresso tests. Use as replacement to the `scrollTo` calls which only work on `ScrollView` and `HorizontalScrollView` implementations.

## Usage

Add this import statement:

`import static com.zmarkan.nestedscroll.ScrollableUtils.scrollableScrollTo;`

Use in the test method:

`onView(withId(R.id.notVisibleView)).perform(scrollableScrollTo()).check(matches(isDisplayed()));`

## Importing in your project

The micro library is hosted on Jitpack so add this to your project's `build.gradle` to access it's dependencies:

```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

Then in your module `build.gradle` include it as such:

```
	dependencies {
	        androidTestCompile 'com.github.zmarkan:android-espresso-scrollablescroll:0.1.0'
	}
```

## License

Licensed under MIT license.




