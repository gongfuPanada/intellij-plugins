package org.angularjs.codeInsight.router;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.SmartPsiElementPointer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Irina.Chernushina on 3/8/2016.
 */
public class UiRouterState {
  @NotNull
  private final String myName;
  private String myUrl;
  private String myTemplateUrl;
  private String myParentName;
  private List<UiView> myViews;
  @Nullable private SmartPsiElementPointer<PsiElement> myPointer;
  private boolean myIsAbstract;
  @NotNull
  private final VirtualFile myFile;
  @Nullable private List<SmartPsiElementPointer<PsiElement>> myDuplicateDefinitions;

  public UiRouterState(@NotNull String name, @NotNull VirtualFile file) {
    myName = name;
    myFile = file;
  }

  @NotNull
  public String getName() {
    return myName;
  }

  public String getUrl() {
    return myUrl;
  }

  public String getTemplateUrl() {
    return myTemplateUrl;
  }

  public String getParentName() {
    return myParentName;
  }

  public void setUrl(String url) {
    myUrl = url;
  }

  public void setTemplateUrl(String templateUrl) {
    myTemplateUrl = templateUrl;
  }

  public void setParentName(String parentName) {
    myParentName = parentName;
  }

  public List<UiView> getViews() {
    return myViews;
  }

  public boolean hasViews() {
    return myViews != null && !myViews.isEmpty();
  }

  public void setViews(List<UiView> views) {
    myViews = views;
  }

  @Nullable
  public SmartPsiElementPointer<PsiElement> getPointer() {
    return myPointer;
  }

  public void setPointer(@Nullable SmartPsiElementPointer<PsiElement> pointer) {
    myPointer = pointer;
  }

  public boolean isAbstract() {
    return myIsAbstract;
  }

  public void setAbstract(boolean anAbstract) {
    myIsAbstract = anAbstract;
  }

  @NotNull
  public VirtualFile getFile() {
    return myFile;
  }

  public void addDuplicateDefinition(@NotNull final UiRouterState state) {
    if (myDuplicateDefinitions == null) myDuplicateDefinitions = new ArrayList<>();
    myDuplicateDefinitions.add(state.getPointer());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UiRouterState state = (UiRouterState)o;

    if (!myName.equals(state.myName)) return false;
    if (!myFile.equals(state.myFile)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = myName.hashCode();
    result = 31 * result + myFile.hashCode();
    return result;
  }
}
