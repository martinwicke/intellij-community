/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.openapi.module;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.java.LanguageLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author yole
 */
public class LanguageLevelUtil extends EffectiveLanguageLevelUtil {
  /**
   * @deprecated use JavaPsiImplementationHelper#getEffectiveLanguageLevel(com.intellij.openapi.vfs.VirtualFile)
   * todo remove in IDEA 15
   */
  @SuppressWarnings({"deprecation", "UnusedDeclaration"})
  @NotNull
  public static LanguageLevel getLanguageLevelForFile(@Nullable VirtualFile file) {
    if (file == null) return LanguageLevel.HIGHEST;

    if (file.isDirectory()) {
      LanguageLevel languageLevel = file.getUserData(LanguageLevel.KEY);
      return languageLevel != null ? languageLevel : LanguageLevel.HIGHEST;
    }

    return getLanguageLevelForFile(file.getParent());
  }
}
