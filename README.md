# FirebaseListener-Android (also support for Kotlin)

## Documentation

### Installation
---
Step 1. Add the JitPack repository to your build file 

```gradle
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```gradle
	dependencies {
	        implementation 'com.github.rommansabbir:FirebaseListener-Android:Tag'
	}
```

---

### Version available

| Releases        
| ------------- |
| v1.1          |
| v1.0          |


# Usages

### For Java: 

```java
public class MainActivity extends AppCompatActivity implements FirebaseListener.FirebaseListenerInterface {
    private FirebaseListener firebaseListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Instantiate FirebaseListener
         */
        firebaseListener = new FirebaseListener(this);
        /**
         * Pass your db reference path to get data from FirebaseDatabase
         */
        firebaseListener.getData("YOUR_DB_REF_PATH");
    }

    @Override
    public void onFirebaseListenerSuccess(DataSnapshot dataSnapshot) {
        //TODO Implement your logic here
    }

    @Override
    public void onFirebaseListenerFailure(DatabaseError databaseError) {
        //TODO Implement your logic here
    }
}
```




### For Kotlin: 

```kotlin
class MainActivity : AppCompatActivity(), FirebaseListenerKt.FirebaseListenerInterface{
    private lateinit var firebaseListenerKt : FirebaseListenerKt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Instantiate FirebaseListenerKt
         */
        firebaseListenerKt  = FirebaseListenerKt(this)
        /**
         * Pass your db reference path to get data from FirebaseDatabase
         */
        firebaseListenerKt.getData("YOUR_DB_REF_PATH")

    }

    override fun onFirebaseListenerFailure(databaseError: DatabaseError) {
        //TODO Implement your logic here
    }

    override fun onFirebaseListenerSuccess(dataSnapshot: DataSnapshot) {
        //TODO Implement your logic here
    }
}
```

### Contact me
[Portfolio](https://www.rommansabbir.com/) | [LinkedIn](https://www.linkedin.com/in/rommansabbir/) | [Twitter](https://www.twitter.com/itzrommansabbir/) | [Facebook](https://www.facebook.com/itzrommansabbir/)

