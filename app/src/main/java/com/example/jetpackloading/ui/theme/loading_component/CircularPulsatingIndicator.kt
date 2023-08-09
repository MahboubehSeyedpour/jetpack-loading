import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.ANIMATION_DURATION
import com.example.jetpackloading.CIRCULAR_PROGRESS_MAX_SIZE
import com.example.jetpackloading.CIRCULAR_PROGRESS_Min_SIZE

@Composable
fun CircularPulsatingIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    animationDuration: Int = ANIMATION_DURATION,
    progress: Float = 0.8f,
    initialValue: Float = CIRCULAR_PROGRESS_Min_SIZE,
    targetValue: Float = CIRCULAR_PROGRESS_MAX_SIZE,
    strokeWidth: Dp = 0.2.dp
) {

    val transition = rememberInfiniteTransition()

    // Scaling Animation
    val size by transition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration / 2, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Turning Around Animation
    val rotationAngle by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Box {
        CircularProgressIndicator(
            modifier = Modifier
                .size(targetValue.dp)
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = size,
                    scaleY = size,
                    rotationY = rotationAngle,
                    rotationZ = rotationAngle
                ),
            color = color,
            progress = progress,
            strokeWidth = strokeWidth
        )
    }
}