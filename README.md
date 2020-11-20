Some Kotlin extension methods to change layout constraints programmatically easily
# Sample

```kotlin
class MainActivity : Activity() {
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.wrapperConstraintLayout)
        val textView = findViewById(R.id.textView) // by default, this view align left && top of parent
        textView.setOnClickListener { toRightBottom(it) }
    }
    
    // let's make it align to right && bottom of parent
    fun toRightBottom(view: View) {
        constraintLayout.applyConstraint {
            view.apply {
                clearStart() // remove left constraint
                clearTop()   // remove top constraint
                end_toEndOfParent() // add right constraint
                bottom_toBottomOfParent() // add bottom constraint
            }
        }
    }
}
```
