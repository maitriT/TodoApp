package com.neosoft.todoapp.fragments

import android.os.Build
import android.view.View
import android.widget.Spinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.neosoft.todoapp.R
import com.neosoft.todoapp.data.models.Priority
import com.neosoft.todoapp.data.models.ToDoData
import com.neosoft.todoapp.fragments.list.ListFragmentDirections

class BindingAdapters {

	companion object {
		@BindingAdapter("android:navigateToAddFragment")
		@JvmStatic
		fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean) {
			view.setOnClickListener {
				if (navigate) {
					// add new note in todo list
					view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
				}
			}
		}

		@BindingAdapter("android:sendDataToUpdateFragment")
		@JvmStatic
		fun navigateToAddFragment(view: ConstraintLayout, currentItem: ToDoData) {
			view.setOnClickListener {
				val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
				view.findNavController().navigate(action)
			}
		}

		@BindingAdapter("android:emptyDatabase")
		@JvmStatic
		fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>) {
			when (emptyDatabase.value) {
				true -> view.visibility = View.VISIBLE
				false -> view.visibility = View.INVISIBLE
				else -> {}
			}
		}

		@BindingAdapter("android:parsePriorityToInt")
		@JvmStatic
		fun parsePriorityToInt(spinner: Spinner, priority: Priority) {
			when (priority) {
				Priority.High -> spinner.setSelection(0)
				Priority.Medium -> spinner.setSelection(1)
				Priority.Low -> spinner.setSelection(2)
			}
		}

		@BindingAdapter("android:parsePriorityColor")
		@JvmStatic
		fun parsePriorityColor(cardView: CardView, priority: Priority) {
			when (priority) {
				Priority.High -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					cardView.setCardBackgroundColor(
						cardView.context.getColor(
							R.color.red
						)
					)
				}
				Priority.Medium -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					cardView.setCardBackgroundColor(
						cardView.context.getColor(
							R.color.yellow
						)
					)
				}
				Priority.Low -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					cardView.setCardBackgroundColor(
						cardView.context.getColor(
							R.color.green
						)
					)
				}
			}
		}
	}
}