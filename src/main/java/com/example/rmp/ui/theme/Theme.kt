package com.example.rmp.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.rmp.backgroundDark
import com.example.rmp.backgroundDarkHighContrast
import com.example.rmp.backgroundDarkMediumContrast
import com.example.rmp.backgroundLight
import com.example.rmp.backgroundLightHighContrast
import com.example.rmp.backgroundLightMediumContrast
import com.example.rmp.errorContainerDark
import com.example.rmp.errorContainerDarkHighContrast
import com.example.rmp.errorContainerDarkMediumContrast
import com.example.rmp.errorContainerLight
import com.example.rmp.errorContainerLightHighContrast
import com.example.rmp.errorContainerLightMediumContrast
import com.example.rmp.errorDark
import com.example.rmp.errorDarkHighContrast
import com.example.rmp.errorDarkMediumContrast
import com.example.rmp.errorLight
import com.example.rmp.errorLightHighContrast
import com.example.rmp.errorLightMediumContrast
import com.example.rmp.inverseOnSurfaceDark
import com.example.rmp.inverseOnSurfaceDarkHighContrast
import com.example.rmp.inverseOnSurfaceDarkMediumContrast
import com.example.rmp.inverseOnSurfaceLight
import com.example.rmp.inverseOnSurfaceLightHighContrast
import com.example.rmp.inverseOnSurfaceLightMediumContrast
import com.example.rmp.inversePrimaryDark
import com.example.rmp.inversePrimaryDarkHighContrast
import com.example.rmp.inversePrimaryDarkMediumContrast
import com.example.rmp.inversePrimaryLight
import com.example.rmp.inversePrimaryLightHighContrast
import com.example.rmp.inversePrimaryLightMediumContrast
import com.example.rmp.inverseSurfaceDark
import com.example.rmp.inverseSurfaceDarkHighContrast
import com.example.rmp.inverseSurfaceDarkMediumContrast
import com.example.rmp.inverseSurfaceLight
import com.example.rmp.inverseSurfaceLightHighContrast
import com.example.rmp.inverseSurfaceLightMediumContrast
import com.example.rmp.onBackgroundDark
import com.example.rmp.onBackgroundDarkHighContrast
import com.example.rmp.onBackgroundDarkMediumContrast
import com.example.rmp.onBackgroundLight
import com.example.rmp.onBackgroundLightHighContrast
import com.example.rmp.onBackgroundLightMediumContrast
import com.example.rmp.onErrorContainerDark
import com.example.rmp.onErrorContainerDarkHighContrast
import com.example.rmp.onErrorContainerDarkMediumContrast
import com.example.rmp.onErrorContainerLight
import com.example.rmp.onErrorContainerLightHighContrast
import com.example.rmp.onErrorContainerLightMediumContrast
import com.example.rmp.onErrorDark
import com.example.rmp.onErrorDarkHighContrast
import com.example.rmp.onErrorDarkMediumContrast
import com.example.rmp.onErrorLight
import com.example.rmp.onErrorLightHighContrast
import com.example.rmp.onErrorLightMediumContrast
import com.example.rmp.onPrimaryContainerDark
import com.example.rmp.onPrimaryContainerDarkHighContrast
import com.example.rmp.onPrimaryContainerDarkMediumContrast
import com.example.rmp.onPrimaryContainerLight
import com.example.rmp.onPrimaryContainerLightHighContrast
import com.example.rmp.onPrimaryContainerLightMediumContrast
import com.example.rmp.onPrimaryDark
import com.example.rmp.onPrimaryDarkHighContrast
import com.example.rmp.onPrimaryDarkMediumContrast
import com.example.rmp.onPrimaryLight
import com.example.rmp.onPrimaryLightHighContrast
import com.example.rmp.onPrimaryLightMediumContrast
import com.example.rmp.onSecondaryContainerDark
import com.example.rmp.onSecondaryContainerDarkHighContrast
import com.example.rmp.onSecondaryContainerDarkMediumContrast
import com.example.rmp.onSecondaryContainerLight
import com.example.rmp.onSecondaryContainerLightHighContrast
import com.example.rmp.onSecondaryContainerLightMediumContrast
import com.example.rmp.onSecondaryDark
import com.example.rmp.onSecondaryDarkHighContrast
import com.example.rmp.onSecondaryDarkMediumContrast
import com.example.rmp.onSecondaryLight
import com.example.rmp.onSecondaryLightHighContrast
import com.example.rmp.onSecondaryLightMediumContrast
import com.example.rmp.onSurfaceDark
import com.example.rmp.onSurfaceDarkHighContrast
import com.example.rmp.onSurfaceDarkMediumContrast
import com.example.rmp.onSurfaceLight
import com.example.rmp.onSurfaceLightHighContrast
import com.example.rmp.onSurfaceLightMediumContrast
import com.example.rmp.onSurfaceVariantDark
import com.example.rmp.onSurfaceVariantDarkHighContrast
import com.example.rmp.onSurfaceVariantDarkMediumContrast
import com.example.rmp.onSurfaceVariantLight
import com.example.rmp.onSurfaceVariantLightHighContrast
import com.example.rmp.onSurfaceVariantLightMediumContrast
import com.example.rmp.onTertiaryContainerDark
import com.example.rmp.onTertiaryContainerDarkHighContrast
import com.example.rmp.onTertiaryContainerDarkMediumContrast
import com.example.rmp.onTertiaryContainerLight
import com.example.rmp.onTertiaryContainerLightHighContrast
import com.example.rmp.onTertiaryContainerLightMediumContrast
import com.example.rmp.onTertiaryDark
import com.example.rmp.onTertiaryDarkHighContrast
import com.example.rmp.onTertiaryDarkMediumContrast
import com.example.rmp.onTertiaryLight
import com.example.rmp.onTertiaryLightHighContrast
import com.example.rmp.onTertiaryLightMediumContrast
import com.example.rmp.outlineDark
import com.example.rmp.outlineDarkHighContrast
import com.example.rmp.outlineDarkMediumContrast
import com.example.rmp.outlineLight
import com.example.rmp.outlineLightHighContrast
import com.example.rmp.outlineLightMediumContrast
import com.example.rmp.outlineVariantDark
import com.example.rmp.outlineVariantDarkHighContrast
import com.example.rmp.outlineVariantDarkMediumContrast
import com.example.rmp.outlineVariantLight
import com.example.rmp.outlineVariantLightHighContrast
import com.example.rmp.outlineVariantLightMediumContrast
import com.example.rmp.primaryContainerDark
import com.example.rmp.primaryContainerDarkHighContrast
import com.example.rmp.primaryContainerDarkMediumContrast
import com.example.rmp.primaryContainerLight
import com.example.rmp.primaryContainerLightHighContrast
import com.example.rmp.primaryContainerLightMediumContrast
import com.example.rmp.primaryDark
import com.example.rmp.primaryDarkHighContrast
import com.example.rmp.primaryDarkMediumContrast
import com.example.rmp.primaryLight
import com.example.rmp.primaryLightHighContrast
import com.example.rmp.primaryLightMediumContrast
import com.example.rmp.scrimDark
import com.example.rmp.scrimDarkHighContrast
import com.example.rmp.scrimDarkMediumContrast
import com.example.rmp.scrimLight
import com.example.rmp.scrimLightHighContrast
import com.example.rmp.scrimLightMediumContrast
import com.example.rmp.secondaryContainerDark
import com.example.rmp.secondaryContainerDarkHighContrast
import com.example.rmp.secondaryContainerDarkMediumContrast
import com.example.rmp.secondaryContainerLight
import com.example.rmp.secondaryContainerLightHighContrast
import com.example.rmp.secondaryContainerLightMediumContrast
import com.example.rmp.secondaryDark
import com.example.rmp.secondaryDarkHighContrast
import com.example.rmp.secondaryDarkMediumContrast
import com.example.rmp.secondaryLight
import com.example.rmp.secondaryLightHighContrast
import com.example.rmp.secondaryLightMediumContrast
import com.example.rmp.surfaceDark
import com.example.rmp.surfaceDarkHighContrast
import com.example.rmp.surfaceDarkMediumContrast
import com.example.rmp.surfaceLight
import com.example.rmp.surfaceLightHighContrast
import com.example.rmp.surfaceLightMediumContrast
import com.example.rmp.surfaceVariantDark
import com.example.rmp.surfaceVariantDarkHighContrast
import com.example.rmp.surfaceVariantDarkMediumContrast
import com.example.rmp.surfaceVariantLight
import com.example.rmp.surfaceVariantLightHighContrast
import com.example.rmp.surfaceVariantLightMediumContrast
import com.example.rmp.tertiaryContainerDark
import com.example.rmp.tertiaryContainerDarkHighContrast
import com.example.rmp.tertiaryContainerDarkMediumContrast
import com.example.rmp.tertiaryContainerLight
import com.example.rmp.tertiaryContainerLightHighContrast
import com.example.rmp.tertiaryContainerLightMediumContrast
import com.example.rmp.tertiaryDark
import com.example.rmp.tertiaryDarkHighContrast
import com.example.rmp.tertiaryDarkMediumContrast
import com.example.rmp.tertiaryLight
import com.example.rmp.tertiaryLightHighContrast
import com.example.rmp.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}

