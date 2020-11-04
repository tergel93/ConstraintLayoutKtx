package me.tergel.constraintlayoutktx

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.applyConstraint(operations: Constraint.() -> Unit) {
    val constraint = Constraint(this)
    operations(constraint)
    constraint.set.applyTo(this)
}

class Constraint(layout: ConstraintLayout) {
    val set: ConstraintSet by lazy {
        val newSet = ConstraintSet()
        newSet.clone(layout)
        newSet
    }


    fun <V : View> V.start_to_start_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.START, targetId(), ConstraintSet.START)
    }

    fun <V : View> V.start_to_end_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.START, targetId(), ConstraintSet.END)
    }

    fun <V : View> V.end_to_end_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.END, targetId(), ConstraintSet.END)
    }

    fun <V : View> V.end_to_start_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.END, targetId(), ConstraintSet.START)
    }

    fun <V : View> V.top_to_top_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.TOP, targetId(), ConstraintSet.TOP)
    }

    fun <V : View> V.top_to_bottom_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.TOP, targetId(), ConstraintSet.BOTTOM)
    }

    fun <V : View> V.bottom_to_top_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.BOTTOM, targetId(), ConstraintSet.TOP)
    }

    fun <V : View> V.bottom_to_bottom_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.BOTTOM, targetId(), ConstraintSet.BOTTOM)
    }

    fun <V : View> V.start_to_start_of_parent() {
        set.connect(this.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
    }

    fun <V : View> V.start_to_end_of_parent() {
        set.connect(this.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.END)
    }

    fun <V : View> V.end_to_end_of_parent() {
        set.connect(this.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
    }

    fun <V : View> V.end_to_start_of_parent() {
        set.connect(this.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.START)
    }

    fun <V : View> V.top_to_top_of_parent() {
        set.connect(this.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
    }

    fun <V : View> V.top_to_bottom_of_parent() {
        set.connect(this.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
    }

    fun <V : View> V.bottom_to_top_of_parent() {
        set.connect(this.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
    }

    fun <V : View> V.bottom_to_bottom_of_parent() {
        set.connect(this.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
    }

    fun <V : View> V.clearStart() {
        set.clear(this.id, ConstraintSet.START)
    }

    fun <V : View> V.clearEnd() {
        set.clear(this.id, ConstraintSet.END)
    }

    fun <V : View> V.clearTop() {
        set.clear(this.id, ConstraintSet.TOP)
    }

    fun <V : View> V.clearBottom() {
        set.clear(this.id, ConstraintSet.BOTTOM)
    }

    fun <V : View> V.baseline_to_baseline_of(targetId: () -> Int) {
        set.connect(this.id, ConstraintSet.BASELINE, targetId(), ConstraintSet.BASELINE)
    }
}
