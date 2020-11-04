Some Kotlin extension methods to change layout constraints programmatically easily
# Sample

```kotlin
class MainActivity : Activity() {
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.wrapperConstraintLayout)
        val textView = findViewById(R.id.textView)
        textView.setOnClickListener { toLeft(it) }
    }

    fun toLeft(view: View) {
        constraintLayout.applyConstraint {
            view.apply {
                clearEnd() // remove end_to_end_of_parent constraint
                start_to_start_of_parent()
            }
        }
        TransitionManager.beginDelayedTransition(constraintLayout)
        view.setOnClickListener { toRight(view) }
    }


    fun toRight(view: View) {
        constraintLayout.applyConstraint {
            view.apply {
                clearStart()
                end_to_end_of_parent()
            }
        }
        view.setOnClickListener { toLeft(view) }
    }
}
```
