package dev.tsnanh.android.spotifyclone.utils.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import dev.tsnanh.android.spotifyclone.common.UiConstants
import kotlinx.coroutines.delay

@Stable
fun Modifier.alphaScaleClickable(
    keepEffectDuration: Long = 50L,
    enabled: Boolean = true,
    pressedScale: Float = UiConstants.PressedScale,
    pressedAlpha: Float = UiConstants.PressedAlpha,
    onPressStateChange: (isPress: Boolean) -> Unit = {},
    onClick: () -> Unit = {},
) = composed {
    val interactions = remember { mutableStateListOf<Interaction>() }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed = interactions.any { it is PressInteraction.Press }
    onPressStateChange(isPressed)
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> interactions.add(interaction)
                is PressInteraction.Release -> {
                    delay(keepEffectDuration)
                    interactions.remove(interaction.press)
                }
                is PressInteraction.Cancel -> {
                    delay(keepEffectDuration)
                    interactions.remove(interaction.press)
                }
                is DragInteraction.Start -> interactions.add(interaction)
                is DragInteraction.Stop -> {
                    delay(keepEffectDuration)
                    interactions.remove(interaction.start)
                }
                is DragInteraction.Cancel -> {
                    delay(keepEffectDuration)
                    interactions.remove(interaction.start)
                }
            }
        }
    }
    this
        .scale(if (isPressed) pressedScale else 1F)
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled,
            onClick = onClick
        )
        .graphicsLayer(
            alpha = if (isPressed) pressedAlpha else 1F
        )
}
