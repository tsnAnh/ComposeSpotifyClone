package dev.tsnanh.android.spotifyclone.common.composables

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun SpotifyCloneButtonPressEffect(
    throttleFirstDuration: Long = 50L,
    content: @Composable (interactionSource: MutableInteractionSource, isPressed: Boolean) -> Unit,
) {
    val interactions = remember { mutableStateListOf<Interaction>() }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed = interactions.any { it is PressInteraction.Press }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> interactions.add(interaction)
                is PressInteraction.Release -> {
                    delay(throttleFirstDuration)
                    interactions.remove(interaction.press)
                }
                is PressInteraction.Cancel -> {
                    delay(throttleFirstDuration)
                    interactions.remove(interaction.press)
                }
                is DragInteraction.Start -> interactions.add(interaction)
                is DragInteraction.Stop -> {
                    delay(throttleFirstDuration)
                    interactions.remove(interaction.start)
                }
                is DragInteraction.Cancel -> {
                    delay(throttleFirstDuration)
                    interactions.remove(interaction.start)
                }
            }
        }
    }
    content(interactionSource, isPressed)
}
