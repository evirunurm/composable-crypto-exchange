package com.quinientoscuarenta.myjcapplication.templates

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun PageTemplate(
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit
) {
    // TODO: Why is this not applying a general margin?
    ConstraintLayout(modifier) {
        val (contentRef) = createRefs()
        val topGuideline = createGuidelineFromTop(0.1f)
        val bottomGuideline = createGuidelineFromBottom(0.1f)
        val startGuideline = createGuidelineFromStart(0.1f)
        val endGuideline = createGuidelineFromEnd(0.1f)

        content(Modifier.constrainAs(contentRef) {
            top.linkTo(topGuideline)
            bottom.linkTo(bottomGuideline)
            start.linkTo(startGuideline)
            end.linkTo(endGuideline)
        })
    }
}
