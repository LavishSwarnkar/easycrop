package com.mr0xf00.easycrop.sample.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.mr0xf00.easycrop.AspectRatio
import com.mr0xf00.easycrop.CropState
import com.mr0xf00.easycrop.CropperLoading
import com.mr0xf00.easycrop.sample.ui.theme.EasyCropTheme

@Composable
fun DemoContent(
    cropState: CropState?,
    loadingStatus: CropperLoading?,
    selectedImage: ImageBitmap?,
    onPick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (cropState != null) {
        EasyCropTheme(darkTheme = true) {
            com.mr0xf00.easycrop.ui.ImageCropperDialog(
                state = cropState,
                showAspectRatioSelectionButton = false,
                showShapeCropButton = false,
                lockAspectRatio = AspectRatio(4, 3)
            )
        }
    }
    if (cropState == null && loadingStatus != null) {
        LoadingDialog(status = loadingStatus)
    }
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedImage != null) Image(
            bitmap = selectedImage, contentDescription = null,
            modifier = Modifier.weight(1f)
        ) else Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Text("No image selected !")
        }
        Button(onClick = onPick) { Text("Choose Image") }
    }
}
